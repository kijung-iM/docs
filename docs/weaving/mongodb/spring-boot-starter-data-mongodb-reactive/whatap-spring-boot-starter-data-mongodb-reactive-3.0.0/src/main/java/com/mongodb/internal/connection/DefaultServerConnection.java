package com.mongodb.internal.connection;

import com.mongodb.ReadPreference;
import com.mongodb.RequestContext;
import com.mongodb.ServerApi;
import com.mongodb.connection.*;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;
import org.bson.BsonDocument;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.spring.boot.starter.data.mongodb.reactive.WeaveConf;

@Weaving
public class DefaultServerConnection {

    private InternalConnection wrapped;
    public static String weaveDatabaseAddress;
    public static ClusterDescription weaveClusterDescription;

    public <T> void commandAsync(String database, BsonDocument command, FieldNameValidator commandFieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, ServerApi serverApi, RequestContext requestContext, boolean responseExpected, SplittablePayload payload, FieldNameValidator payloadFieldNameValidator, SingleResultCallback<T> callback) {
        TraceContext ctx = DefaultConnectionPool.getContext(wrapped);
        long stime = System.nanoTime() / 1000000;

        try {
            OriginMethod.call();
        } finally {
            if (callback.getClass().getSimpleName().startsWith("CommandOperationHelper")
                    || callback.getClass().getSimpleName().startsWith("MixedBulkWriteOperation")) {
                if (ctx != null) {
                    long etime = System.nanoTime() / 1000000;
                    int elapsed = (int) (etime - stime);
                    WeaveConf.traceSql(ctx, getMongoAddress(), command.toJson(), null, elapsed, null);
                }
            }
        }
    }

    public <T> void commandAsync(String database, BsonDocument command, FieldNameValidator commandFieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, boolean responseExpected, SplittablePayload payload, FieldNameValidator payloadFieldNameValidator, SingleResultCallback<T> callback) {
        TraceContext ctx = DefaultConnectionPool.getContext(wrapped);
        long stime = System.nanoTime() / 1000000;

        try {
            OriginMethod.call();
        } finally {
            if (callback.getClass().getSimpleName().startsWith("CommandOperationHelper")
                    || callback.getClass().getSimpleName().startsWith("MixedBulkWriteOperation")) {
                if (ctx != null) {
                    long etime = System.nanoTime() / 1000000;
                    int elapsed = (int) (etime - stime);
                    WeaveConf.traceSql(ctx, getMongoAddress(), command.toJson(), null, elapsed, null);
                }
            }
        }
    }

    public String getMongoAddress() {
        StringBuilder mongoAddress = new StringBuilder();
        if (weaveClusterDescription != null) {
            int size = weaveClusterDescription.getServerDescriptions().size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ServerDescription serverDescription = weaveClusterDescription.getServerDescriptions().get(i);
                    if (serverDescription != null) {
                        if (i > 0) mongoAddress.append(",");
                        mongoAddress.append(serverDescription.getAddress()).append("[").append(serverDescription.getType()).append("]");
                    }
                }
            }
        } else {
            if (weaveDatabaseAddress != null) {
                mongoAddress = new StringBuilder(weaveDatabaseAddress);
            } else {
                mongoAddress = new StringBuilder("mongodb-reactive");
            }
        }
        return mongoAddress.toString();
    }

}
