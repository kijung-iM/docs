package io.lettuce.core;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

import java.time.Duration;

// Standalone
@Weaving
public class RedisClient {

    // Standalone
    @SuppressWarnings("unchecked")
    private <K, V> ConnectionFuture<StatefulRedisConnection<K, V>> connectStandaloneAsync(RedisCodec<K, V> codec, RedisURI redisURI, Duration timeout) {
        ConnectionFuture<StatefulRedisConnection<K, V>> tmpResult = OriginMethod.call();
        return new WeaveRedisClient<K, V>().connectStatefulAsyncWrapper(tmpResult, redisURI);
    }
}
