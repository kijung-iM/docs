package org.springframework.messaging.support;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.HttpCall;
import whatap.weaving.v1.Log;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.Iterator;
import java.util.Map;

@Weaving
public class MessageBuilder<T> {

    private T payload;

    @Nullable
    private Message<T> providedMessage;

    private MessageHeaderAccessor headerAccessor;

    @SuppressWarnings("unchecked")
    public Message<T> build() {
        try {
            TraceCtx ctx = Trace.context();
            Map<String, String> header = HttpCall.mtrace(ctx);
            if (header != null) {
                Iterator<Map.Entry<String, String>> itr = header.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, String> entr = itr.next();
                    this.headerAccessor.setHeader(entr.getKey(), entr.getValue());
                }
            }
        } catch (Throwable t) {
            Log.println("[kafka] message build failed");
        }

        return OriginMethod.call();
    }
}
