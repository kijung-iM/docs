package com.mongodb.internal.connection;

import com.mongodb.MongoServerUnavailableException;
import com.mongodb.connection.*;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;


@Weaving
public abstract class DefaultServer {

    private ServerId serverId;
    private ConnectionPool connectionPool;
    private ClusterConnectionMode clusterConnectionMode;
    private ConnectionFactory connectionFactory;
    private SdamServerDescriptionManager sdam;
    private volatile boolean isClosed;

    class WeaveAsyncConnectionWrapper implements SingleResultCallback<InternalConnection> {

        SingleResultCallback<AsyncConnection> callback;
        SdamServerDescriptionManager.SdamIssue.Context exceptionContext;
        TraceContext ctx;

        public WeaveAsyncConnectionWrapper(SingleResultCallback<AsyncConnection> callback, SdamServerDescriptionManager.SdamIssue.Context exceptionContext, TraceContext ctx) {
            this.callback = callback;
            this.exceptionContext = exceptionContext;
            this.ctx = ctx;
        }

        @Override
        public void onResult(InternalConnection result, Throwable t) {
            if (ctx != null) {
                TraceContextManager.attach(ctx);
            }

            if (t != null) {
                try {
                    operationEnd();
                    sdam.handleExceptionBeforeHandshake(SdamServerDescriptionManager.SdamIssue.specific(t, exceptionContext));
                } finally {
                    callback.onResult(null, t);
                }
            } else {
                callback.onResult(AsyncOperationCountTrackingConnection.decorate(DefaultServer.this,
                        connectionFactory.createAsync(result, new DefaultServerProtocolExecutor(), clusterConnectionMode)), null);
            }
        }
    }

    public void getConnectionAsync(final SingleResultCallback<AsyncConnection> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();

        if (isClosed) {
            callback.onResult(null, new MongoServerUnavailableException(
                    String.format("The server at %s is no longer available", serverId.getAddress())));
            return;
        }
        SdamServerDescriptionManager.SdamIssue.Context exceptionContext = sdam.context();
        operationBegin();

        connectionPool.getAsync(new WeaveAsyncConnectionWrapper(callback, exceptionContext, ctx));
    }

    private void operationBegin() {
        OriginMethod.call();
    }

    private void operationEnd() {
        OriginMethod.call();
    }

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

    @SkipLoad
    private static final class AsyncOperationCountTrackingConnection {
        static AsyncConnection decorate(final DefaultServer server, final AsyncConnection connection) {
            return OriginMethod.call();
        }
    }
}
