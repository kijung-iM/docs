package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.MongoSocketClosedException;
import com.mongodb.ServerAddress;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.connection.*;
import org.bson.ByteBuf;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.List;

import static com.mongodb.assertions.Assertions.isTrue;

@Weaving
public abstract class InternalStreamConnection implements InternalConnection {

    private volatile Stream stream;
    private ServerId serverId;
    private StreamFactory streamFactory;
    private InternalConnectionInitializer connectionInitializer;

    private void initAfterHandshakeStart(final InternalConnectionInitializationDescription initializationDescription) {
        OriginMethod.call();
    }

    private void initAfterHandshakeFinish(final InternalConnectionInitializationDescription initializationDescription) {
        OriginMethod.call();
    }

    // openAsync
    class WeaveAsyncCompletionHandler implements AsyncCompletionHandler<Void> {

        SingleResultCallback<Void> callback;
        TraceContext tCtx;

        public WeaveAsyncCompletionHandler(SingleResultCallback<Void> callback, TraceContext ctx) {
            this.callback = callback;
            this.tCtx = ctx;
        }

        @Override
        public void completed(final Void aVoid) {
            TraceContextManager.attach(this.tCtx);

            connectionInitializer.startHandshakeAsync(InternalStreamConnection.this,
                    (initialResult, initialException) -> {
                        if (initialException != null) {
                            close();
                            callback.onResult(null, initialException);
                        } else {
                            initAfterHandshakeStart(initialResult);
                            connectionInitializer.finishHandshakeAsync(InternalStreamConnection.this,
                                    initialResult, (completedResult, completedException) -> {
                                        if (completedException != null) {
                                            close();
                                            callback.onResult(null, completedException);
                                        } else {
                                            initAfterHandshakeFinish(completedResult);
                                            callback.onResult(null, null);
                                        }
                                    });
                        }
                    });
        }

        @Override
        public void failed(final Throwable t) {
            TraceContextManager.attach(this.tCtx);

            close();
            callback.onResult(null, t);
        }
    }

    public void openAsync(SingleResultCallback<Void> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();

        isTrue("Open already called", stream == null, callback);
        try {
            stream = streamFactory.create(serverId.getAddress());
            stream.openAsync(new WeaveAsyncCompletionHandler(callback, ctx));
        } catch (Throwable t) {
            close();
            callback.onResult(null, t);
        }
    }

    private void readAsync(final int numBytes, final SingleResultCallback<ByteBuf> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();

        if (isClosed()) {
            callback.onResult(null, new MongoSocketClosedException("Cannot read from a closed stream", getServerAddress()));
            return;
        }

        try {
            stream.readAsync(numBytes, new WeaveAsyncCompletionHandlerByteBuf(callback, ctx));
        } catch (Exception e) {
            close();
            callback.onResult(null, translateReadException(e));
        }
    }

    // readAsync
    class WeaveAsyncCompletionHandlerByteBuf implements AsyncCompletionHandler<ByteBuf> {
        SingleResultCallback<ByteBuf> callback;
        TraceContext tCtx;

        public WeaveAsyncCompletionHandlerByteBuf(SingleResultCallback<ByteBuf> callback, TraceContext ctx) {
            this.callback = callback;
            this.tCtx = ctx;
        }

        @Override
        public void completed(final ByteBuf buffer) {
            TraceContextManager.attach(this.tCtx);

            callback.onResult(buffer, null);
        }

        @Override
        public void failed(final Throwable t) {
            TraceContextManager.attach(this.tCtx);

            close();
            callback.onResult(null, translateReadException(t));
        }
    }

    private void writeAsync(final List<ByteBuf> byteBuffers, final SingleResultCallback<Void> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();

        stream.writeAsync(byteBuffers, new WeaveAsyncCompletionHandlerVoid(callback, ctx));
    }

    // writeAsync
    class WeaveAsyncCompletionHandlerVoid implements AsyncCompletionHandler<Void> {

        SingleResultCallback<Void> callback;
        TraceContext tCtx;

        public WeaveAsyncCompletionHandlerVoid(SingleResultCallback<Void> callback, TraceContext ctx) {
            this.callback = callback;
            this.tCtx = ctx;
        }

        @Override
        public void completed(final Void v) {
            TraceContextManager.attach(this.tCtx);

            callback.onResult(null, null);
        }

        @Override
        public void failed(final Throwable t) {
            TraceContextManager.attach(this.tCtx);

            close();
            callback.onResult(null, translateWriteException(t));
        }
    }


    public abstract void close();

    public abstract boolean isClosed();

    protected abstract ServerAddress getServerAddress();

    protected abstract MongoException translateReadException(final Throwable e);

    protected abstract MongoException translateWriteException(final Throwable e);
}
