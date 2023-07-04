package org.springframework.http.server.reactive;

import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpMethod;

import io.undertow.server.HttpServerExchange;
import whatap.agent.api.trace.TxStat;
import whatap.agent.api.trace.TxTrace;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.lang.ref.OBJECT;
import whatap.spring.undertow.RequestUndertow;
import whatap.spring.undertow.ResponseUndertow;

@Weaving
abstract public class UndertowHttpHandlerAdapter {
    private static Log logger;
    private HttpHandler httpHandler;

    public void handleRequest(HttpServerExchange exchange) {
        UndertowServerHttpRequest request = null;
        try {
            request = new UndertowServerHttpRequest(exchange, getDataBufferFactory());
        } catch (URISyntaxException ex) {
            if (logger.isWarnEnabled()) {
                logger.debug("Failed to get request URI: " + ex.getMessage());
            }
            exchange.setStatusCode(400);
            return;
        }
        ServerHttpResponse response = new UndertowServerHttpResponse(exchange, getDataBufferFactory(), request);

        if (request.getMethod() == HttpMethod.HEAD) {
            response = new HttpHeadResponseDecorator(response);
        }

        OBJECT<Throwable> th = new OBJECT<Throwable>();
        final TxStat stat = TxTrace.startHttpTx(new RequestUndertow(request, response), new ResponseUndertow(response));

        HandlerResultSubscriber resultSubscriber = new HandlerResultSubscriber(exchange, request);

        this.httpHandler.handle(request, response).doOnError(ex -> {
            th.value = ex;
        }).doFinally(aVoid -> {
            // Mono 최종 완료시 트랜잭션 종료
            TxTrace.endHttpTx(stat, th.value);
        }).subscribe(resultSubscriber);

    }

    @SkipLoad
    private static class HandlerResultSubscriber implements Subscriber<Void> {
        public HandlerResultSubscriber(HttpServerExchange exchange, UndertowServerHttpRequest request) {
        }

        public void onSubscribe(Subscription subscription) {
        }

        public void onNext(Void aVoid) {
        }

        public void onError(Throwable ex) {
        }

        public void onComplete() {
        }
    }

    abstract public DataBufferFactory getDataBufferFactory();
}
