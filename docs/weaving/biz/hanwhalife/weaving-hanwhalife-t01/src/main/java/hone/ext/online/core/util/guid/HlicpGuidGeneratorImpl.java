package hone.ext.online.core.util.guid;

import hone.ext.online.web.message.HlicpMessageHeader;
import whatap.agent.Configure;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.plugin.WrContext;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@Weaving
public class HlicpGuidGeneratorImpl {

    public HlicpMessageHeader createMessageHeader() {
        HlicpMessageHeader result = OriginMethod.call();
        try {
            TraceContext ctx = TraceContextManager.getLocalContext();
            if (ctx != null) {
                String globalNo = result.getGlobalNo();
                if (ctx.custid == null) {
                    boolean trace_hanwha_debug_enabled = Configure.getInstance().getBoolean("trace_hanwha_debug_enabled", false);
                    if (trace_hanwha_debug_enabled) {
                        WrContext wrContext = new WrContext(ctx);
                        wrContext.profile("hanwhalife", "HlicpGuidGeneratorImpl  globalNo=" + globalNo);
                    }
                }
                ctx.customTrace(globalNo);
            }
        } catch (Throwable ignore) {
        }

        return result;
    }
}
