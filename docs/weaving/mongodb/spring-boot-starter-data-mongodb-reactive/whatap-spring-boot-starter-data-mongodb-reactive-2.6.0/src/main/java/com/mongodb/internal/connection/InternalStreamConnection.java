package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.MongoSocketClosedException;
import com.mongodb.ServerAddress;
import com.mongodb.connection.*;
import com.mongodb.internal.async.SingleResultCallback;
import org.bson.ByteBuf;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.List;

@Weaving
public abstract class InternalStreamConnection {

    private volatile Stream stream;

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
        try {
            stream.writeAsync(byteBuffers, new WeaveAsyncCompletionHandlerVoid(callback, ctx));
        } catch (Throwable t) {
            close();
            callback.onResult(null, t);
        }
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
