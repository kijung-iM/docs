package okhttp3;

import whatap.agent.Logger;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.conf.ConfMTrace;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@SkipLoad
abstract public class Request {

    abstract public HttpUrl url();

    @Weaving
    public class Builder {
        Headers.Builder headers;

        public Request build() {
            try {
                if (ConfMTrace.mtrace_enabled && headers != null) {
                    TraceContext ctx = TraceContextManager.getLocalContext();
                    if (ctx != null) {
                        headers.add(ConfMTrace._trace_mtrace_poid_key, TraceContext.transferPOID());
                        if (ConfMTrace.stat_mtrace_enabled) {
                            headers.add(ConfMTrace._trace_mtrace_spec_key1, ctx.transferSPEC_URL1());
                        }
                        if (ConfMTrace.mtid_mtrace_enabled && ctx.mtid != 0) {
                            headers.add(ConfMTrace._trace_mtrace_caller_key, ctx.transferMTID_CALLERTX());
                        }
                    }
                }
            } catch (Throwable e) {
                Logger.println("okhttp-4.6.0", 10, e);
            }
            return OriginMethod.call();
        }

    }
}
