package io.lettuce.core.cluster;

import java.util.concurrent.CompletableFuture;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.cluster.models.partitions.Partitions;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

// cluster
@Weaving
class PooledClusterConnectionProvider<K, V> {

    private Partitions partitions;

    // Intent.WRITE
    private CompletableFuture<StatefulRedisConnection<K, V>> getWriteConnection(int slot) {
        CompletableFuture<StatefulRedisConnection<K, V>> tmpResult = OriginMethod.call();
        RedisClusterNode weaveClusterNode = partitions.getPartitionBySlot(slot);
        return new WeaveRedisCluster<K, V>().getWriteConnectionWrapper(tmpResult, slot, weaveClusterNode);
    }

    // Intent.READ
    private CompletableFuture<StatefulRedisConnection<K, V>> getReadConnection(int slot) {
        CompletableFuture<StatefulRedisConnection<K, V>> tmpResult = OriginMethod.call();
        RedisClusterNode weaveClusterNode = partitions.getPartitionBySlot(slot);
        return new WeaveRedisCluster<K, V>().getReadConnectionWrapper(tmpResult, slot, weaveClusterNode);
    }

}
