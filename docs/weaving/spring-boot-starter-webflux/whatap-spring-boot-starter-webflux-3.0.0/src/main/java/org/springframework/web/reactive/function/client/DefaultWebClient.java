package org.springframework.web.reactive.function.client;

import java.net.URI;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;
import whatap.agent.Logger;
import whatap.agent.api.trace.HttpCallSpec;
import whatap.agent.api.trace.TxHttpC;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.conf.ConfMTrace;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;
import whatap.agent.trace.TraceHttpc;
import whatap.lang.ref.OBJECT;
import whatap.spring.netty.StaticThreadLocal;

import static java.lang.Long.valueOf;

@SkipLoad
public class DefaultWebClient {
    @Weaving
    abstract class DefaultRequestBodyUriSpec {

        abstract protected URI initUri();

        public Mono<ClientResponse> exchange() {

            final Mono<ClientResponse> m = OriginMethod.call();

            final OBJECT<Object> stat = new OBJECT<Object>();

            try {
                URI u = initUri();
                int port = u.getPort() < 0 ? 0 : u.getPort();
                String path = u.getPath();
                if (path == null || path.length() == 0) {
                    path = "/";
                }
                HttpCallSpec spec = new HttpCallSpec();
                spec.driver = "WebFlux";
                spec.host = u.getHost();
                spec.port = port;
                spec.url = path;

                Long stepId = StaticThreadLocal.stepIdTable.get();
                if (stepId != null) {
                    spec.stepId = stepId.longValue();
                }

                stat.value = TxHttpC.startHttpCall(spec);
            } catch (Throwable t) {
            }

            final OBJECT<Throwable> th = new OBJECT<Throwable>();
            return m.doOnError(ex -> {
                th.value = ex;
            }).doFinally(aVoid -> {
                try {
                    ClientResponse resp = StaticThreadLocal.get();
                    if (resp != null) {
                        int code = resp.rawStatusCode();
                        String reason = code == 200 ? null : HttpStatus.valueOf(code).getReasonPhrase();
                        TxHttpC.endHttpc(stat.value, code, reason, th.value);
                    } else {
                        TxHttpC.endHttpc(stat.value, 200, null, th.value);
                    }
                } catch (Throwable t) {
                }
            });
        }

        private HttpHeaders initHeaders() {
            HttpHeaders h = OriginMethod.call();

            if (ConfMTrace.mtrace_enabled) {
                try {
                    HttpHeaders h2 = new HttpHeaders();
                    if (h != null) {
                        h2.putAll(h);
                    }
                    $transfer(h2);
                    return h2;
                } catch (Throwable t) {
                    Logger.println("WEBFLUX-CLIENT", 10, t);
                }
            }
            return h;
        }

        private void $transfer(HttpHeaders headers) {
            try {
                if (ConfMTrace.mtrace_enabled) {
                    TraceContext ctx = TraceContextManager.getCurrentAsyncContext();
                    if (ctx != null) {
                        TraceHttpc.setRatedMtraceKey(ctx);

                        headers.add(ConfMTrace._trace_mtrace_poid_key, TraceContext.transferPOID());
                        if (ConfMTrace.stat_mtrace_enabled) {
                            headers.add(ConfMTrace._trace_mtrace_spec_key1, ctx.transferSPEC_URL1());
                        }
                        if (ConfMTrace.mtid_mtrace_enabled && ctx.mtid != 0) {
                            long stepId = TraceContext.getNextCallerStepId();
                            StaticThreadLocal.stepIdTable.set(valueOf(stepId));
                            headers.add(ConfMTrace._trace_mtrace_caller_key, ctx.transferMTID_CALLERTX(stepId));
                        }
                    }
                }
            } catch (Throwable e) {
                Logger.println("A134", 10, e);
            }
        }
    }

}
