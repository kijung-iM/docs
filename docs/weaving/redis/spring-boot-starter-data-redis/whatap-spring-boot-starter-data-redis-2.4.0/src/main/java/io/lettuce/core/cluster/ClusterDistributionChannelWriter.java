/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.cluster;

import io.lettuce.core.StatefulRedisConnectionImpl;
import io.lettuce.core.WeaveConf;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import io.lettuce.core.protocol.RedisCommand;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Sql;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

/**
 * Channel writer for cluster operation. This writer looks up the right partition by hash/slot for the operation.
 *
 * @author Mark Paluch
 * @since 3.0
 */
@Weaving
class ClusterDistributionChannelWriter {

    private static TraceCtx weaveCtx;
    private <K, V, T> RedisCommand<K, V, T> doWrite(RedisCommand<K, V, T> command) {
        weaveCtx = Trace.context();
        return OriginMethod.call();
    }

    // cluster
    @SuppressWarnings("unchecked")
    private static <K, V> void writeCommand(RedisCommand<K, V, ?> command, boolean asking,
                                            StatefulRedisConnection<K, V> connection, Throwable throwable) {
        TraceCtx ctx = Trace.context();
        if (ctx == null) {
            ctx = weaveCtx;
            weaveCtx = null;
        }

        long stime = System.nanoTime() / 1000000;
        Throwable thr = throwable;

        try {
            OriginMethod.call();
        } catch (Exception e) {
            thr = e;
            command.completeExceptionally(e);
        } finally {
            if (ctx != null) {
                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);
                if (elapsed >= WeaveConf.redis_lettuce_basetime) {
                    StringBuilder dbStr = new StringBuilder();
                    if (connection instanceof StatefulRedisConnectionImpl) {
                        StatefulRedisConnectionImpl connectionInstance = (StatefulRedisConnectionImpl) connection;
                        RedisClusterNode weaveClusterNode = connectionInstance.weaveClusterNode;

                        if (weaveClusterNode != null) {
                            dbStr.append(weaveClusterNode.getUri().toURI()).append(" ").append(weaveClusterNode.getFlags());
                        }
                    }
                    Sql.trace(ctx, dbStr.toString(), command.getType().name(), null, elapsed, thr);
                }
            }
        }
    }

}
