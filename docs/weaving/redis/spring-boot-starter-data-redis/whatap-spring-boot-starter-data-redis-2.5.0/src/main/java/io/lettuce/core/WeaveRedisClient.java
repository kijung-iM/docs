package io.lettuce.core;

import io.lettuce.core.api.StatefulRedisConnection;

import java.util.function.BiConsumer;

// Standalone
public class WeaveRedisClient<K, V> {

    // Standalone
    public <K, V> ConnectionFuture<StatefulRedisConnection<K, V>> connectStatefulAsyncWrapper(ConnectionFuture<StatefulRedisConnection<K, V>> connection, RedisURI redisURI) {
        BiConsumer<StatefulRedisConnection<K, V>, Throwable> b = new BiConsumer<StatefulRedisConnection<K, V>, Throwable>() {
            @Override
            public void accept(StatefulRedisConnection<K, V> kvStatefulRedisConnection, Throwable throwable) {
                if (kvStatefulRedisConnection instanceof StatefulRedisConnectionImpl) {
                    StatefulRedisConnectionImpl statefulRedisConnection = (StatefulRedisConnectionImpl) kvStatefulRedisConnection;
                    statefulRedisConnection.weaveRedisURI = redisURI;
                }
            }
        };
        return connection.whenComplete(b);
    }
}
