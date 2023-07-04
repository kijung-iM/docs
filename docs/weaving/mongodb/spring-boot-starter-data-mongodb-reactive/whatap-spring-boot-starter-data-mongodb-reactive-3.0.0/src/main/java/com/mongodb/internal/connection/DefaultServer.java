package com.mongodb.internal.connection;

import com.mongodb.*;
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
        TraceContext tCtx;

        public WeaveAsyncConnectionWrapper(SingleResultCallback<AsyncConnection> callback, SdamServerDescriptionManager.SdamIssue.Context exceptionContext, TraceContext ctx) {
            this.callback = callback;
            this.exceptionContext = exceptionContext;
            this.tCtx = ctx;
        }

        @Override
        public void onResult(InternalConnection result, Throwable t) {
            DefaultConnectionPool.setContext(result, this.tCtx);
            TraceContextManager.attach(this.tCtx);

            if (t != null) {
                try {
                    DefaultServer.this.operationEnd();
                    DefaultServer.this.sdam.handleExceptionBeforeHandshake(SdamServerDescriptionManager.SdamIssue.specific(t, exceptionContext));
                } finally {
                    callback.onResult((AsyncConnection) null, t);
                }
            } else {
                callback.onResult(DefaultServer.AsyncOperationCountTrackingConnection.decorate(DefaultServer.this, DefaultServer.this.connectionFactory.createAsync(result, DefaultServer.this.new DefaultServerProtocolExecutor(), DefaultServer.this.clusterConnectionMode)), (Throwable) null);
            }
        }
    }

    public void getConnectionAsync(final SingleResultCallback<AsyncConnection> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();

        if (this.isClosed) {
            callback.onResult((AsyncConnection) null, new MongoServerUnavailableException(String.format("The server at %s is no longer available", this.serverId.getAddress())));
        } else {
            final SdamServerDescriptionManager.SdamIssue.Context exceptionContext = this.sdam.context();
            this.operationBegin();

            connectionPool.getAsync(new WeaveAsyncConnectionWrapper(callback, exceptionContext, ctx));
        }
    }

    private void operationEnd() {
        OriginMethod.call();
    }

    protected abstract void operationBegin();

    @Weaving
    private class DefaultServerProtocolExecutor implements ProtocolExecutor {
        public <T> T execute(CommandProtocol<T> protocol, InternalConnection connection, SessionContext sessionContext) {
            return OriginMethod.call();
        }

        public <T> void executeAsync(CommandProtocol<T> protocol, final InternalConnection connection, final SessionContext sessionContext, final SingleResultCallback<T> callback) {
            OriginMethod.call();
        }
    }

    @SkipLoad
    private static final class AsyncOperationCountTrackingConnection {
        static AsyncConnection decorate(DefaultServer server, AsyncConnection connection) {
            return OriginMethod.call();
        }
    }

}
