package io.lettuce.core;

import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import io.lettuce.core.protocol.*;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Sql;

import java.util.Collection;

@Weaving
public class StatefulRedisConnectionImpl<K, V> {

    // standalone
    public RedisURI weaveRedisURI;

    // cluster
    public RedisClusterNode weaveClusterNode;

    // Standalone
    public <T> RedisCommand<K, V, T> dispatch(RedisCommand<K, V, T> command) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);

            StringBuilder dbStr = new StringBuilder();
            StringBuilder commandStr = new StringBuilder();

            if (weaveRedisURI != null) {
                dbStr.append(weaveRedisURI.toURI()).append(":").append(weaveRedisURI.getPort());
            }
            commandStr.append(command.getType().name());
            Sql.trace(dbStr.toString(), commandStr.toString(), null, elapsed, null);
        }
    }

}
