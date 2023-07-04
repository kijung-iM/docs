package org.springframework.web.socket.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import static whatap.spring.boot.websocket.sockjs.WeaveConf.*;

@Weaving
public abstract class AbstractWebSocketHandler {

    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        TraceCtx ctx = null;
        long stime = 0;
        Throwable thr = null;
        if (websocket_sockjs_trace_enabled) {
            ctx = Trace.start(session.getUri().toString());
            stime = System.nanoTime() / 1000000;
        }
        try {
            OriginMethod.call();
        } catch (Exception e) {
            thr = e;
        } finally {
            if (ctx != null) {
                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);

                if (elapsed > websocket_sockjs_basetime) {
                    if (websocket_sockjs_profile_enabled) {
                        if (message instanceof TextMessage) {
                            StringBuilder sb = new StringBuilder();
                            if (message.getPayload() != null) sb.append(message.getPayload().toString());
                            Trace.step(ctx, websocket_sockjs_step_title, sb.toString(), elapsed, 0);
                        }
                    }
                }
                Trace.end(ctx, thr);
            }
        }
    }
}
