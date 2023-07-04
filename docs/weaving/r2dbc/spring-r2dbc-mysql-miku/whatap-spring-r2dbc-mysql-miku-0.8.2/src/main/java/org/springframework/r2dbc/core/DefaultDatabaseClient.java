package org.springframework.r2dbc.core;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.r2dbc.mysql.miku.util.WeaveConf;
import whatap.weaving.v1.Sql;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.function.Supplier;

import static dev.miku.r2dbc.mysql.MySqlConnectionFactory.weaveAddress;
import static dev.miku.r2dbc.mysql.MySqlConnectionFactory.weaveDatabase;

@Weaving
public class DefaultDatabaseClient {

    public DatabaseClient.GenericExecuteSpec sql(String sql) {
        return OriginMethod.call();
    }

    public DatabaseClient.GenericExecuteSpec sql(Supplier<String> sqlSupplier) {
        long stime = System.nanoTime() / 1000000;
        TraceCtx ctx = Trace.context();
        try {
            return OriginMethod.call();
        } finally {
            if (ctx != null) {
                StringBuilder dbHostBuilder = new StringBuilder();
                if (weaveAddress != null) {
                    dbHostBuilder.append(weaveAddress.getHostName()).append(":").append(weaveAddress.getPort());
                    if (weaveDatabase != null) {
                        dbHostBuilder.append("/").append(weaveDatabase);
                    }
                } else {
                    dbHostBuilder.append(WeaveConf.title_spring_r2dbc_mysql_miku);
                }

                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);
                Sql.trace(ctx, dbHostBuilder.toString(), sqlSupplier.get(), null, elapsed, null);
            }
        }
    }

}
