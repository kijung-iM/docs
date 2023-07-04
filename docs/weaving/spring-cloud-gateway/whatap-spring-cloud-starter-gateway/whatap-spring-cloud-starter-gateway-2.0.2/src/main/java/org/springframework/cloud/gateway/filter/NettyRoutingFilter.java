package org.springframework.cloud.gateway.filter;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.NettyPipeline;
import reactor.ipc.netty.http.client.HttpClient;
import reactor.ipc.netty.http.client.HttpClientRequest;
import reactor.ipc.netty.http.client.HttpClientResponse;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter.Type;
import org.springframework.cloud.gateway.support.TimeoutException;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.NettyDataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.AbstractServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.HttpCall;
import whatap.weaving.v1.HttpCallCtx;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.Iterator;
import java.util.Map;

import static org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter.filterRequest;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.PRESERVE_HOST_HEADER_ATTRIBUTE;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.isAlreadyRouted;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.setAlreadyRouted;

@Weaving
abstract public class NettyRoutingFilter implements GlobalFilter, Ordered {

    private HttpClient httpClient;
    private ObjectProvider<List<HttpHeadersFilter>> headersFilters;
    private HttpClientProperties properties;

    @Override
    abstract public int getOrder();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);

        String scheme = requestUrl.getScheme();
        if (isAlreadyRouted(exchange) || (!"http".equals(scheme) && !"https".equals(scheme))) {
            return chain.filter(exchange);
        }
        setAlreadyRouted(exchange);

        ServerHttpRequest request = exchange.getRequest();

        final HttpMethod method = HttpMethod.valueOf(request.getMethod().toString());
        final String url = requestUrl.toString();

        HttpHeaders filtered = filterRequest(this.headersFilters.getIfAvailable(),
                exchange);

        // ################################################## begin:whatap
        TraceCtx wctx = null;
        try {
            List<String> ctxTraceIdList = filtered.get("whatap_ctx_trace_id");
            if (ctxTraceIdList != null && ctxTraceIdList.size() > 0) {
                long ctxTraceId = Long.parseLong(ctxTraceIdList.get(0));
                wctx = Trace.context(ctxTraceId);
                Trace.attach(wctx);
            }
        } catch (Exception e) {
        }

        HttpCallCtx stat = HttpCall.start(requestUrl.getHost(), requestUrl.getPort(), url);
        // ################################################## end:whatap

        final DefaultHttpHeaders httpHeaders = new DefaultHttpHeaders();
        filtered.forEach(httpHeaders::set);

        String transferEncoding = request.getHeaders().getFirst(HttpHeaders.TRANSFER_ENCODING);
        boolean chunkedTransfer = "chunked".equalsIgnoreCase(transferEncoding);

        boolean preserveHost = exchange.getAttributeOrDefault(PRESERVE_HOST_HEADER_ATTRIBUTE, false);

        // ################################################## begin:whatap
        final TraceCtx finalCtx = wctx;
        // ################################################## end:whatap

        Mono<HttpClientResponse> responseMono = this.httpClient.request(method, url, req -> {
            final HttpClientRequest proxyRequest = req.options(NettyPipeline.SendOptions::flushOnEach)
                    .headers(httpHeaders)
                    .chunkedTransfer(chunkedTransfer)
                    .failOnServerError(false)
                    .failOnClientError(false);

            if (preserveHost) {
                String host = request.getHeaders().getFirst(HttpHeaders.HOST);
                proxyRequest.header(HttpHeaders.HOST, host);
            }

            // ################################################## begin:whatap
            $transfer(finalCtx, req);
            // ################################################## end:whatap

            if (properties.getResponseTimeout() != null) {
                proxyRequest.context(ctx -> ctx.addHandlerFirst(
                        new ReadTimeoutHandler(properties.getResponseTimeout().toMillis(), TimeUnit.MILLISECONDS)));
            }

            return proxyRequest.sendHeaders() //I shouldn't need this
                    .send(request.getBody().map(dataBuffer ->
                            ((NettyDataBuffer) dataBuffer).getNativeBuffer()));
        });

        return responseMono.doOnNext(res -> {
            ServerHttpResponse response = exchange.getResponse();
            // put headers and status so filters can modify the response
            HttpHeaders headers = new HttpHeaders();

            res.responseHeaders().forEach(entry -> headers.add(entry.getKey(), entry.getValue()));

            String contentTypeValue = headers.getFirst(HttpHeaders.CONTENT_TYPE);
            if (StringUtils.hasLength(contentTypeValue)) {
                exchange.getAttributes().put(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR, contentTypeValue);
            }

            HttpHeaders filteredResponseHeaders = HttpHeadersFilter.filter(
                    this.headersFilters.getIfAvailable(), headers, exchange, Type.RESPONSE);

            response.getHeaders().putAll(filteredResponseHeaders);
            HttpStatus status = HttpStatus.resolve(res.status().code());
            if (status != null) {

                // ################################################## begin:whatap
                HttpCall.end(stat, res.status().code(), res.status().reasonPhrase(), null);
                // ################################################## end:whatap

                response.setStatusCode(status);
            } else if (response instanceof AbstractServerHttpResponse) {

                // ################################################## begin:whatap
                HttpCall.end(stat, res.status().code(), null, null);
                // ################################################## end:whatap

                // https://jira.spring.io/browse/SPR-16748
                ((AbstractServerHttpResponse) response).setStatusCodeValue(res.status().code());
            } else {

                // ################################################## begin:whatap
                HttpCall.end(stat, res.status().code(), response.getClass().getName(), null);
                // ################################################## end:whatap

                throw new IllegalStateException("Unable to set status code on response: " +res.status().code()+", "+response.getClass());
            }

            // Defer committing the response until all route filters have run
            // Put client response as ServerWebExchange attribute and write response later NettyWriteResponseFilter
            exchange.getAttributes().put(CLIENT_RESPONSE_ATTR, res);
        })
                .onErrorMap(t -> properties.getResponseTimeout() != null && t instanceof ReadTimeoutException,

                        // ################################################## begin:whatap
                        // original
//                        t -> new TimeoutException("Response took longer than timeout: "
//                                properties.getResponseTimeout()))

                        // custom
                        (t) -> {
                            HttpCall.end(stat, HttpStatus.GATEWAY_TIMEOUT.value(), t.getMessage(), t);
                            return new TimeoutException("Response took longer than timeout: " +
                                    properties.getResponseTimeout());
                        })
                        // ################################################## end:whatap

                .then(chain.filter(exchange));
    }

    // ################################################## begin:whatap
    private void $transfer(TraceCtx ctx, HttpClientRequest req) {
        try {
            Trace.attach(ctx);
            Map<String, String> header = HttpCall.mtrace(ctx);
            if (header != null) {
                Iterator<String> itr = header.keySet().iterator();
                while (itr.hasNext()) {
                    String key = itr.next();
                    req.header(key, header.get(key));
                }
            }
        } catch (Throwable e) {
        }
    }
    // ################################################## end:whatap

}
