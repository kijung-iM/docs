package org.springframework.messaging.handler.invocation;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.HandlerMethod;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import static whatap.spring.boot.websocket.stomp.messaging.WeaveConf.*;

@Weaving
public abstract class AbstractMethodMessageHandler<T> {

    protected void handleMatch(T mapping, HandlerMethod handlerMethod, String lookupDestination, Message<?> message) {
        TraceCtx ctx = null;
        long stime = 0;
        if (websocket_trace_enabled) {
            ctx = Trace.start(lookupDestination);
            stime = System.nanoTime() / 1000000;
        }
        try {
            OriginMethod.call();
        } finally {
            if (ctx != null) {
                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);

                if (elapsed > websocket_basetime) {
                    if (websocket_profile_enabled) {
                        MessageHeaders weaveHeader = message.getHeaders();
                        StringBuilder sb = new StringBuilder();
                        Object simpMessageTypeObject = weaveHeader.get("simpMessageType");
                        Object stompCommandObject    = weaveHeader.get("stompCommand");
                        if (simpMessageTypeObject != null) sb.append("type=").append(simpMessageTypeObject).append(" ");
                        if (stompCommandObject != null)    sb.append("command=").append(stompCommandObject);

                        Trace.step(ctx, websocket_step_title, sb.toString(), elapsed, 0);
                    }
                }
                Trace.end(ctx, null);
            }
        }
    }

    protected void processHandlerMethodException(HandlerMethod handlerMethod, Exception exception, Message<?> message) {
        if (websocket_trace_exception) Trace.exception(exception);
        OriginMethod.call();
    }
}
