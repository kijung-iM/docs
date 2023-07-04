package retrofit2;

import okhttp3.Headers;
import whatap.agent.Logger;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.conf.ConfMTrace;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@Weaving
public class RequestFactory {

    @Weaving
    static final class Builder {
        private Headers parseHeaders(String[] headers) {
            Headers result = OriginMethod.call();

            okhttp3.Headers.Builder weaveBuilder = new okhttp3.Headers.Builder();
            weaveBuilder.addAll(result);
            try {
                if (ConfMTrace.mtrace_enabled && headers != null) {
                    TraceContext ctx = TraceContextManager.getLocalContext();
                    if (ctx != null) {
                        weaveBuilder.add(ConfMTrace._trace_mtrace_poid_key, TraceContext.transferPOID());
                        if (ConfMTrace.stat_mtrace_enabled) {
                            weaveBuilder.add(ConfMTrace._trace_mtrace_spec_key1, ctx.transferSPEC_URL1());
                        }
                        if (ConfMTrace.mtid_mtrace_enabled && ctx.mtid != 0) {
                            weaveBuilder.add(ConfMTrace._trace_mtrace_caller_key, ctx.transferMTID_CALLERTX());
                        }
                    }
                }
            } catch (Throwable e) {
                Logger.println("retrofit-2.5.0", 10, e);
            }

            return weaveBuilder.build();
        }
    }

}
