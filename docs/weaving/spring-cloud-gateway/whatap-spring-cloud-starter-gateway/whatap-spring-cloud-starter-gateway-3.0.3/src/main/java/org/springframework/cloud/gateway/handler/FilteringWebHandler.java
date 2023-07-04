package org.springframework.cloud.gateway.handler;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.List;

@Weaving
public class FilteringWebHandler {

    @Weaving
    private static class DefaultGatewayFilterChain implements GatewayFilterChain {
        private final int index;
        private final List<GatewayFilter> filters;

        DefaultGatewayFilterChain(List<GatewayFilter> filters) {
            this.filters = filters;
            this.index = 0;
        }

        private DefaultGatewayFilterChain(DefaultGatewayFilterChain parent, int index) {
            this.filters = parent.getFilters();
            this.index = index;
        }

        public List<GatewayFilter> getFilters() {
            return this.filters;
        }

        public Mono<Void> filter(ServerWebExchange exchange) {
            return Mono.defer(() -> {
                if (this.index < this.filters.size()) {
                    GatewayFilter filter = this.filters.get(this.index);
                    DefaultGatewayFilterChain chain = new DefaultGatewayFilterChain(this, this.index + 1);

                    // ################################################## begin:whatap
                    TraceCtx ctx = Trace.context();
                    if (ctx != null) Trace.attach(ctx);
                    // ################################################## end:whatap

                    return filter.filter(exchange, chain);
                } else {
                    return Mono.empty();
                }
            });
        }
    }
}
