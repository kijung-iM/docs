package org.springframework.web.reactive.function.client;

import org.springframework.http.client.reactive.ClientHttpResponse;

import whatap.agent.api.weaving.Weaving;
import whatap.spring.netty.StaticThreadLocal;

@Weaving
abstract public class DefaultClientResponse implements ClientResponse {
    public DefaultClientResponse(ClientHttpResponse response, ExchangeStrategies strategies, String logPrefix) {
        StaticThreadLocal.put(this);
    }
}
