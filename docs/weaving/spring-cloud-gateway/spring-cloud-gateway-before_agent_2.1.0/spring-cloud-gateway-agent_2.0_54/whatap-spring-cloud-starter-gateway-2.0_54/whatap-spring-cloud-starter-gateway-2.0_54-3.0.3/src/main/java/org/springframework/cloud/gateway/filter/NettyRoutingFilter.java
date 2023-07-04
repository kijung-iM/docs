package org.springframework.cloud.gateway.filter;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientRequest;
import reactor.netty.http.client.HttpClientResponse;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter.Type;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.TimeoutException;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.NettyDataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.AbstractServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import whatap.agent.api.weaving.Weaving;
import whatap.v1.HttpCall;
import whatap.v1.HttpCallCtx;
import whatap.v1.Trace;
import whatap.v1.TraceCtx;

import static org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter.filterRequest;
import static org.springframework.cloud.gateway.support.RouteMetadataUtils.CONNECT_TIMEOUT_ATTR;
import static org.springframework.cloud.gateway.support.RouteMetadataUtils.RESPONSE_TIMEOUT_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_CONN_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_HEADER_NAMES;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.PRESERVE_HOST_HEADER_ATTRIBUTE;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.isAlreadyRouted;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.setAlreadyRouted;


@Weaving
abstract public class NettyRoutingFilter implements GlobalFilter, Ordered {

    private static Log log;

    private HttpClient httpClient;

    private ObjectProvider<List<HttpHeadersFilter>> headersFiltersProvider;

    private HttpClientProperties properties;

    // do not use this headersFilters directly, use getHeadersFilters() instead.
    private volatile List<HttpHeadersFilter> headersFilters;

    abstract public List<HttpHeadersFilter> getHeadersFilters();

    @Override
    abstract public int getOrder();

    @Override
    @SuppressWarnings("Duplicates")
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);

        String scheme = requestUrl.getScheme();
        if (isAlreadyRouted(exchange) || (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme))) {
            return chain.filter(exchange);
        }
        setAlreadyRouted(exchange);

        ServerHttpRequest request = exchange.getRequest();

        final HttpMethod method = HttpMethod.valueOf(request.getMethodValue());
        final String url = requestUrl.toASCIIString();

        HttpHeaders filtered = filterRequest(getHeadersFilters(), exchange);

        // ################################################## begin:whatap
        TraceCtx ctx = null;
        try {
            List<String> ctxTraceIdList = filtered.get("whatap_ctx_trace_id");
            if(ctxTraceIdList!=null && ctxTraceIdList.size()>0) {
                long ctxTraceId = Long.parseLong(ctxTraceIdList.get(0));
                ctx = Trace.context(ctxTraceId);
                Trace.attach(ctx);
            }
        } catch (Exception e) {
        }

        HttpCallCtx stat = HttpCall.start(requestUrl.getHost(), requestUrl.getPort(), url);
        // ################################################## end:whatap

        final DefaultHttpHeaders httpHeaders = new DefaultHttpHeaders();
        filtered.forEach(httpHeaders::set);

        boolean preserveHost = exchange.getAttributeOrDefault(PRESERVE_HOST_HEADER_ATTRIBUTE, false);
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);

        // ################################################## begin:whatap
        final TraceCtx finalCtx = ctx;
        // ################################################## end:whatap

        Flux<HttpClientResponse> responseFlux = getHttpClient(route, exchange).headers(headers -> {
            headers.add(httpHeaders);
            // Will either be set below, or later by Netty
            headers.remove(HttpHeaders.HOST);
            if (preserveHost) {
                String host = request.getHeaders().getFirst(HttpHeaders.HOST);
                headers.add(HttpHeaders.HOST, host);
            }
        }).request(method).uri(url).send((req, nettyOutbound) -> {

            // ################################################## begin:whatap
            $transfer(finalCtx, req);
            // ################################################## end:whatap

            if (log.isTraceEnabled()) {
                nettyOutbound.withConnection(connection -> log.trace("outbound route: "
                        + connection.channel().id().asShortText() + ", inbound: " + exchange.getLogPrefix()));
            }
            return nettyOutbound.send(request.getBody().map(this::getByteBuf));
        }).responseConnection((res, connection) -> {

            // Defer committing the response until all route filters have run
            // Put client response as ServerWebExchange attribute and write
            // response later NettyWriteResponseFilter
            exchange.getAttributes().put(CLIENT_RESPONSE_ATTR, res);
            exchange.getAttributes().put(CLIENT_RESPONSE_CONN_ATTR, connection);

            ServerHttpResponse response = exchange.getResponse();
            // put headers and status so filters can modify the response
            HttpHeaders headers = new HttpHeaders();

            res.responseHeaders().forEach(entry -> headers.add(entry.getKey(), entry.getValue()));

            String contentTypeValue = headers.getFirst(HttpHeaders.CONTENT_TYPE);
            if (StringUtils.hasLength(contentTypeValue)) {
                exchange.getAttributes().put(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR, contentTypeValue);
            }

            // ################################################## begin:whatap
            // original
//            setResponseStatus(res, response);

            // custom
            setResponseStatus(stat, res, response);
            // ################################################## end:whatap

            // make sure headers filters run after setting status so it is
            // available in response
            HttpHeaders filteredResponseHeaders = HttpHeadersFilter.filter(getHeadersFilters(), headers, exchange,
                    Type.RESPONSE);

            if (!filteredResponseHeaders.containsKey(HttpHeaders.TRANSFER_ENCODING)
                    && filteredResponseHeaders.containsKey(HttpHeaders.CONTENT_LENGTH)) {
                // It is not valid to have both the transfer-encoding header and
                // the content-length header.
                // Remove the transfer-encoding header in the response if the
                // content-length header is present.
                response.getHeaders().remove(HttpHeaders.TRANSFER_ENCODING);
            }

            exchange.getAttributes().put(CLIENT_RESPONSE_HEADER_NAMES, filteredResponseHeaders.keySet());

            response.getHeaders().putAll(filteredResponseHeaders);

            return Mono.just(res);
        });

        Duration responseTimeout = getResponseTimeout(route);
        if (responseTimeout != null) {
            responseFlux = responseFlux
                    .timeout(responseTimeout,
                            Mono.error(new TimeoutException("Response took longer than timeout: " + responseTimeout)))
                    .onErrorMap(TimeoutException.class, (th) -> {

                        // ################################################## begin:whatap
                        HttpCall.end(stat, HttpStatus.GATEWAY_TIMEOUT.value(), th.getMessage(), th);
                        // ################################################## end:whatap

                        return new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, th.getMessage(), th);
                    });
        }

        return responseFlux.then(chain.filter(exchange));
    }

    // ################################################## begin:whatap
    // custom
    private void setResponseStatus(HttpCallCtx stat, HttpClientResponse clientResponse, ServerHttpResponse response) {
        HttpStatus status = HttpStatus.resolve(clientResponse.status().code());
        if (status != null) {
            HttpCall.end(stat, clientResponse.status().code(), clientResponse.status().reasonPhrase(), null);
            response.setStatusCode(status);
        }
        else {
            while (response instanceof ServerHttpResponseDecorator) {
                response = ((ServerHttpResponseDecorator) response).getDelegate();
            }
            if (response instanceof AbstractServerHttpResponse) {
                HttpCall.end(stat, clientResponse.status().code(), null, null);
                ((AbstractServerHttpResponse) response).setRawStatusCode(clientResponse.status().code());
            }
            else {
                HttpCall.end(stat, clientResponse.status().code(), response.getClass().getName(), null);

                // TODO: log warning here, not throw error?
                throw new IllegalStateException("Unable to set status code " + clientResponse.status().code()
                        + " on response of type " + response.getClass().getName());
            }
        }
    }
    // ################################################## end:whatap

    // ################################################## begin:whatap
    private void $transfer(TraceCtx ctx, HttpClientRequest req) {
        try {
            Trace.attach(ctx);
            Map<String, String> header = HttpCall.mtrace();
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

    private void setResponseStatus(HttpClientResponse clientResponse, ServerHttpResponse response) {
        HttpStatus status = HttpStatus.resolve(clientResponse.status().code());
        if (status != null) {
            response.setStatusCode(status);
        }
        else {
            while (response instanceof ServerHttpResponseDecorator) {
                response = ((ServerHttpResponseDecorator) response).getDelegate();
            }
            if (response instanceof AbstractServerHttpResponse) {
                ((AbstractServerHttpResponse) response).setRawStatusCode(clientResponse.status().code());
            }
            else {
                // TODO: log warning here, not throw error?
                throw new IllegalStateException("Unable to set status code " + clientResponse.status().code()
                        + " on response of type " + response.getClass().getName());
            }
        }
    }

    abstract protected HttpClient getHttpClient(Route route, ServerWebExchange exchange);

    abstract protected ByteBuf getByteBuf(DataBuffer dataBuffer);

    abstract protected Duration getResponseTimeout(Route route);
}
