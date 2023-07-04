package org.springframework.data.mongodb.repository.query;

import org.springframework.data.mongodb.core.WhaTapConf;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
abstract public class AbstractMongoQuery {

    public String hookQuery;

    public Object execute(Object[] parameters) {
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

            if (thr != null || elapsed >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("query=");
                if (hookQuery == null || hookQuery.length() == 0) {
                    String className = this.getClass().getName();
                    sb.append(className);
                } else {
                    sb.append(hookQuery);
                }

                // parameter
                if (WhaTapConf.mongodb_show_parameter) {
                    if (parameters != null) {
                        for (int i = 0; i < parameters.length; i++) {
                            sb.append(" parameters=").append(parameters[i]);
                        }
                    } else {
                        sb.append(" parameters=").append("null");
                    }
                }

                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), elapsed);
            }
        }
    }
}
