package com.mongodb.internal.connection;

import com.mongodb.MongoSecurityException;
import com.mongodb.MongoSocketException;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.connection.*;
import com.mongodb.session.SessionContext;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import static com.mongodb.assertions.Assertions.isTrue;

@Weaving
public abstract class DefaultServer {

    private ConnectionPool connectionPool;
    private ClusterConnectionMode clusterConnectionMode;
    private ConnectionFactory connectionFactory;

    class WeaveAsyncConnectionWrapper implements SingleResultCallback<InternalConnection> {

        SingleResultCallback<AsyncConnection> callback;
        TraceContext ctx;

        public WeaveAsyncConnectionWrapper(SingleResultCallback<AsyncConnection> callback, TraceContext ctx) {
            this.callback = callback;
            this.ctx = ctx;
        }

        @Override
        public void onResult(InternalConnection result, Throwable t) {
            if (ctx != null) {
                TraceContextManager.attach(ctx);
            }

            if (t instanceof MongoSecurityException) {
                connectionPool.invalidate();
            } else if (t instanceof MongoSocketException) {
                invalidate();
            }

            if (t != null) {
                callback.onResult(null, t);
            } else {
                callback.onResult(connectionFactory.createAsync(result, new DefaultServerProtocolExecutor(), clusterConnectionMode),
                        null);
            }
        }
    }

    public void getConnectionAsync(final SingleResultCallback<AsyncConnection> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();
        isTrue("open", !isClosed());
        connectionPool.getAsync(new WeaveAsyncConnectionWrapper(callback, ctx));
    }

    public abstract void invalidate();

    public abstract boolean isClosed();

    @Weaving
    private class DefaultServerProtocolExecutor implements ProtocolExecutor {
        public <T> T execute(final LegacyProtocol<T> protocol, final InternalConnection connection) {
            return OriginMethod.call();
        }

        public <T> void executeAsync(final LegacyProtocol<T> protocol, final InternalConnection connection,
                                     final SingleResultCallback<T> callback) {
            OriginMethod.call();
        }

        public <T> T execute(final CommandProtocol<T> protocol, final InternalConnection connection,
                             final SessionContext sessionContext) {
            return OriginMethod.call();
        }

        public <T> void executeAsync(final CommandProtocol<T> protocol, final InternalConnection connection,
                                     final SessionContext sessionContext, final SingleResultCallback<T> callback) {
            OriginMethod.call();
        }

    }
}
