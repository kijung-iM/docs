package org.springframework.web.reactive;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.List;

@Weaving
public class DispatcherHandler {

    public Mono<Void> handle(ServerWebExchange exchange) {
        try {
            List<String> ctxTraceIdList = exchange.getRequest().getHeaders().get("whatap_ctx_trace_id");
            if (ctxTraceIdList != null && ctxTraceIdList.size() > 0) {
                long ctxTraceId = Long.parseLong(ctxTraceIdList.get(0));

                TraceContext ctx = TraceContextManager.getContext(ctxTraceId);
                TraceContextManager.attach(ctx);
            }

        } catch (Throwable ignore) {
        }
        return OriginMethod.call();
    }
}
