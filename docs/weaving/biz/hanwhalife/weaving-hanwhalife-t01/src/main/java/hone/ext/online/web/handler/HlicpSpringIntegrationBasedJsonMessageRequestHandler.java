package hone.ext.online.web.handler;

import hone.ext.online.web.message.HlicpSimpleJsonMessage;
import org.springframework.messaging.Message;
import whatap.agent.Configure;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.plugin.WrContext;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@Weaving
public class HlicpSpringIntegrationBasedJsonMessageRequestHandler {

    private Message<?> handleInternal(HlicpSimpleJsonMessage requestMessage) {
        try {
            TraceContext ctx = TraceContextManager.getLocalContext();
            if (ctx != null) {
                String globalNo = requestMessage.getHeader().getGlobalNo();
                if (ctx.custid == null) {
                    boolean trace_hanwha_debug_enabled = Configure.getInstance().getBoolean("trace_hanwha_debug_enabled", false);
                    if (trace_hanwha_debug_enabled) {
                        WrContext wrContext = new WrContext(ctx);
                        wrContext.profile("hanwhalife","HlicpSpringIntegration  globalNo=" + globalNo);
                    }
                }
                ctx.customTrace(globalNo);
            }
        } catch (Throwable ignore) {
        }

        return OriginMethod.call();
    }
}
