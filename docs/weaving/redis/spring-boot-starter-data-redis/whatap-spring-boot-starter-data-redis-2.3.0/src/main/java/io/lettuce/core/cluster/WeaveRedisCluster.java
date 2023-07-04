package io.lettuce.core.cluster;

import io.lettuce.core.StatefulRedisConnectionImpl;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

// cluster
public class WeaveRedisCluster<K, V> {

    // Intent.WRITE
    public CompletableFuture<StatefulRedisConnection<K, V>> getWriteConnectionWrapper(CompletableFuture<StatefulRedisConnection<K, V>> r, int slot, RedisClusterNode redisClusterNode) {
        BiConsumer<StatefulRedisConnection<K, V>, Throwable> b = new BiConsumer<StatefulRedisConnection<K, V>, Throwable>() {
            @Override
            public void accept(StatefulRedisConnection<K, V> src, Throwable thr) {
                if (src instanceof StatefulRedisConnectionImpl) {
                    StatefulRedisConnectionImpl statefulRedisConnection = (StatefulRedisConnectionImpl) src;
                    statefulRedisConnection.weaveClusterNode = redisClusterNode;
                }
            }
        };
        return r.whenComplete(b);
    }

    // Intent.READ
    public CompletableFuture<StatefulRedisConnection<K, V>> getReadConnectionWrapper(CompletableFuture<StatefulRedisConnection<K, V>> connection, int slot, RedisClusterNode redisClusterNode) {
        BiConsumer<StatefulRedisConnection<K, V>, Throwable> b = new BiConsumer<StatefulRedisConnection<K, V>, Throwable>() {
            @Override
            public void accept(StatefulRedisConnection<K, V> src, Throwable thr) {
                if (src instanceof StatefulRedisConnectionImpl) {
                    StatefulRedisConnectionImpl statefulRedisConnection = (StatefulRedisConnectionImpl) src;
                    statefulRedisConnection.weaveClusterNode = redisClusterNode;
                    TraceCtx ctx = Trace.context();
                }
            }
        };
        return connection.whenComplete(b);
    }
}
