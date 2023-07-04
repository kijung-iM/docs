package org.springframework.messaging.support;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.conf.ConfMTrace;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@Weaving
public class MessageBuilder<T> {

    private T payload;

    @Nullable
    private Message<T> providedMessage;

    private MessageHeaderAccessor headerAccessor;

    @SuppressWarnings("unchecked")
    public Message<T> build() {

        /* */
        try {
            TraceContext ctx = TraceContextManager.getLocalContext();
            if (ctx != null) {
                if (ConfMTrace.mtrace_enabled) {
                    this.headerAccessor.setHeader("x-wtap-po", ctx.transferPOID());
                    this.headerAccessor.setHeader("x-wtap-sp1", ctx.transferSPEC_URL1());
                    if (ctx.mtid != 0) {
                        this.headerAccessor.setHeader("x-wtap-mst", ctx.transferMTID_CALLERTX());
                    }
                }
            }
        } catch (Throwable t) {
        }

        return OriginMethod.call();
    }
}
