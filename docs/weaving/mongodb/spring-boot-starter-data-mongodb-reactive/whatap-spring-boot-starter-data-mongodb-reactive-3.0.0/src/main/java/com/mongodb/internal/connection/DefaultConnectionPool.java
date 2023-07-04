package com.mongodb.internal.connection;

import com.mongodb.MongoTimeoutException;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerId;
import com.mongodb.event.ConnectionCheckOutStartedEvent;
import com.mongodb.event.ConnectionCheckedOutEvent;
import com.mongodb.event.ConnectionPoolListener;
import com.mongodb.internal.Timeout;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.diagnostics.logging.Logger;
import com.mongodb.internal.diagnostics.logging.Loggers;
import com.mongodb.lang.NonNull;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.internal.async.ErrorHandlingResultCallback.errorHandlingCallback;
import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

@Weaving
public class DefaultConnectionPool {

    private static final Logger LOGGER = Loggers.getLogger("connection");

    private ConnectionPoolSettings settings;
    private AsyncWorkManager asyncWorkManager;
    private ConnectionPoolListener connectionPoolListener;
    private ServerId serverId;
    private OpenConcurrencyLimiter openConcurrencyLimiter;
    private StateAndGeneration stateAndGeneration;

    public void getAsync(final SingleResultCallback<InternalConnection> callback) {
        TraceContext localContext = TraceContextManager.getLocalContext();

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(format("Asynchronously getting a connection from the pool for server %s", serverId));
        }
        connectionPoolListener.connectionCheckOutStarted(new ConnectionCheckOutStartedEvent(serverId));
        Timeout timeout = Timeout.startNow(settings.getMaxWaitTime(NANOSECONDS));

        SingleResultCallback<InternalConnection> eventSendingCallback = (result, failure) -> {
            SingleResultCallback<InternalConnection> errHandlingCallback = errorHandlingCallback(callback, LOGGER);
            if (failure == null) {
                connectionPoolListener.connectionCheckedOut(new ConnectionCheckedOutEvent(getId(result)));
                errHandlingCallback.onResult(result, null);
            } else {
                errHandlingCallback.onResult(null, checkOutFailed(failure));
            }
        };

        try {
            stateAndGeneration.throwIfClosedOrPaused();
        } catch (Exception e) {
            eventSendingCallback.onResult(null, e);
            return;
        }
        asyncWorkManager.enqueue(new Task(timeout, t -> {
            if (t != null) {
                eventSendingCallback.onResult(null, t);
            } else {
                PooledConnection connection;
                try {
                    connection = getPooledConnection(timeout);

                    // localContext to connection
                    if (localContext != null) connection.ctx = localContext;

                } catch (Exception e) {
                    eventSendingCallback.onResult(null, e);
                    return;
                }
                if (connection.opened()) {

                    // localContext to connection
                    connection.ctx = localContext;

                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace(format("Pooled connection %s to server %s is already open",
                                getId(connection), serverId));
                    }
                    eventSendingCallback.onResult(connection, null);
                } else {
                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace(format("Pooled connection %s to server %s is not yet open",
                                getId(connection), serverId));
                    }

                    // localContext to connection
                    connection.ctx = localContext;

                    openConcurrencyLimiter.openAsyncWithConcurrencyLimit(connection, timeout, eventSendingCallback);
                }
            }
        }));
    }

    private PooledConnection getPooledConnection(final Timeout timeout) throws MongoTimeoutException {
        return OriginMethod.call();
    }

    @ThreadSafe
    @Weaving
    private final class StateAndGeneration {
        boolean throwIfClosedOrPaused() {
            return OriginMethod.call();
        }
    }

    private ConnectionId getId(final InternalConnection internalConnection) {
        return OriginMethod.call();
    }

    private Throwable checkOutFailed(final Throwable t) {
        return OriginMethod.call();
    }

    @Weaving
    private class PooledConnection implements InternalConnection {

        public TraceContext ctx;

        public void openAsync(final SingleResultCallback<Void> callback) {
            TraceContextManager.attach(this.ctx);

            OriginMethod.call();
        }

        public boolean opened() {
            return OriginMethod.call();
        }

        void release() {
            ctx = null;
            OriginMethod.call();
        }
    }

    public static TraceContext getContext(InternalConnection c) {
        if (c != null) {
            if (c instanceof PooledConnection) {
                return ((PooledConnection) c).ctx;
            }
        }
        return null;
    }

    public static void setContext(InternalConnection c, TraceContext ctx) {
        if (c instanceof PooledConnection) {
            ((PooledConnection) c).ctx = ctx;
        }
    }

    private void connectionCreated(final ConnectionPoolListener connectionPoolListener, final ConnectionId connectionId) {
        OriginMethod.call();
    }

    @Weaving
    private final class OpenConcurrencyLimiter {
        void openAsyncWithConcurrencyLimit(
                final PooledConnection connection, final Timeout timeout, final SingleResultCallback<InternalConnection> callback) {
            if (connection != null) {
                if (connection.ctx != null) {
                    TraceContextManager.attach(connection.ctx);
                }
            }

            OriginMethod.call();
        }
    }

    @SkipLoad
    private static final class MongoOpenConnectionInternalException extends RuntimeException {
        MongoOpenConnectionInternalException(@NonNull final Throwable cause) {
        }
    }

    @Weaving
    private static class AsyncWorkManager {

        private void workerRun() {
            OriginMethod.call();
        }

        void enqueue(final Task task) {
            OriginMethod.call();
        }
    }

    @Weaving
    final class Task {
        private Timeout timeout;
        private Consumer<RuntimeException> action;
        private boolean completed;
        TraceContext tCtx;

        Task(final Timeout timeout, final Consumer<RuntimeException> action) {
            TraceContext localContext = TraceContextManager.getLocalContext();
            this.tCtx = localContext;
        }

        private void doComplete(final Supplier<RuntimeException> failureSupplier) {
            TraceContextManager.attach(this.tCtx);
            if (this.tCtx != null) {
                setContext(null, this.tCtx);
            }

            assertFalse(completed);
            completed = true;
            action.accept(failureSupplier.get());
        }

    }

}
