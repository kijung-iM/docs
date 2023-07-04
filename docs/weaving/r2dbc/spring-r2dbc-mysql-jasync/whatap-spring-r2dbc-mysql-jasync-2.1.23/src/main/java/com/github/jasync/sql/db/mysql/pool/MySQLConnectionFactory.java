package com.github.jasync.sql.db.mysql.pool;

import com.github.jasync.sql.db.Configuration;
import com.github.jasync.sql.db.mysql.MySQLConnection;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Weaving
public class MySQLConnectionFactory {

    public static Configuration weaveConfiguration;

    public CompletableFuture<MySQLConnection> create() {
        CompletableFuture<MySQLConnection> call = null;
        try {
            call = (CompletableFuture<MySQLConnection>) OriginMethod.call();
            return call;
        } finally {
            try {
                weaveConfiguration = call.get().getConfiguration();
            } catch (InterruptedException ignore) {
            } catch (ExecutionException ignore) {
            }
        }
    }
}
