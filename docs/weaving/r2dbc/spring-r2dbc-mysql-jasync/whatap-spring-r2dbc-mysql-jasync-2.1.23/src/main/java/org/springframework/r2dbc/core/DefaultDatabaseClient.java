package org.springframework.r2dbc.core;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.r2dbc.mysql.jasync.util.WeaveConf;
import whatap.weaving.v1.Sql;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.function.Supplier;

import static com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory.weaveConfiguration;

@Weaving
public class DefaultDatabaseClient {

    public DatabaseClient.GenericExecuteSpec sql(Supplier<String> sqlSupplier) {
        long stime = System.nanoTime() / 1000000;
        TraceCtx ctx = Trace.context();
        try {
            return OriginMethod.call();
        } finally {
            if (ctx != null) {
                StringBuilder dbHostBuilder = new StringBuilder();
                if (weaveConfiguration != null) {
                    dbHostBuilder.append(weaveConfiguration.getHost()).append(":").append(weaveConfiguration.getPort()).append("/").append(weaveConfiguration.getDatabase());
                } else {
                    dbHostBuilder.append(WeaveConf.title_spring_r2dbc_mysql_jasync);
                }

                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);

                Sql.trace(ctx, dbHostBuilder.toString(), sqlSupplier.get(), null, elapsed, null);
            }
        }
    }

}
