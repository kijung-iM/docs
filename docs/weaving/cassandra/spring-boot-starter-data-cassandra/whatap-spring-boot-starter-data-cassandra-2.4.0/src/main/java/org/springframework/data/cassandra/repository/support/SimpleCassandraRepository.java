package org.springframework.data.cassandra.repository.support;

import org.springframework.data.cassandra.core.WhaTapConf;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.List;

@Weaving
public class SimpleCassandraRepository<T, ID> {

    public <S extends T> List<S> saveAll(Iterable<S> entities) {

        TraceContext ctx  = TraceContextManager.getLocalContext();
        TraceContextManager.detach();

        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;
            long elapsed = etime - stime;

            TraceContextManager.attach(ctx);

            if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("saveAll(Iterable<S>)");
                if (WhaTapConf.cassandra_profile_query_enabled) {
                    sb.append(" entity=").append("entities");
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), elapsed);
            }
        }
    }

}
