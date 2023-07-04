package org.springframework.web.reactive.function.client;

import java.util.function.Supplier;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.reactive.ClientHttpResponse;

import whatap.agent.api.weaving.Weaving;
import whatap.spring.netty.StaticThreadLocal;

@Weaving
abstract public class DefaultClientResponse implements ClientResponse {
    public DefaultClientResponse(ClientHttpResponse response, ExchangeStrategies strategies,
                                 String logPrefix, String requestDescription, Supplier<HttpRequest> requestSupplier) {
        StaticThreadLocal.put(this);
    }
}
