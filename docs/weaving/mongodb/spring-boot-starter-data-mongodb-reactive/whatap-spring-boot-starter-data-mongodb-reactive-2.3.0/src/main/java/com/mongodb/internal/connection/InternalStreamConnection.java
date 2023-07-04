package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.MongoSocketClosedException;
import com.mongodb.ServerAddress;
import com.mongodb.connection.*;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.SingleResultCallback;
import org.bson.ByteBuf;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

import java.util.List;

@Weaving
public abstract class InternalStreamConnection {

    private static final Logger LOGGER = Loggers.getLogger("connection");

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
            callback.onResult(null, translateReadException(e));
        }
    }

    class WeaveAsyncCompletionHandlerByteBuf implements AsyncCompletionHandler<ByteBuf> {

        SingleResultCallback<ByteBuf> callback;
        TraceContext ctx;

        public WeaveAsyncCompletionHandlerByteBuf(SingleResultCallback<ByteBuf> callback, TraceContext ctx) {
            this.callback = callback;
            this.ctx = ctx;
        }

        @Override
        public void completed(final ByteBuf buffer) {
            TraceContextManager.attach(this.ctx);
            callback.onResult(buffer, null);
        }

        @Override
        public void failed(final Throwable t) {
            TraceContextManager.attach(this.ctx);
            close();
            callback.onResult(null, translateReadException(t));
        }
    }

    private void writeAsync(final List<ByteBuf> byteBuffers, final SingleResultCallback<Void> callback) {
        TraceContext ctx = TraceContextManager.getLocalContext();
        stream.writeAsync(byteBuffers, new WeaveAsyncCompletionHandlerVoid(callback, ctx));
    }

    class WeaveAsyncCompletionHandlerVoid implements AsyncCompletionHandler<Void> {

        SingleResultCallback<Void> callback;
        TraceContext ctx;

        public WeaveAsyncCompletionHandlerVoid(SingleResultCallback<Void> callback, TraceContext ctx) {
            this.callback = callback;
            this.ctx = ctx;
        }

        @Override
        public void completed(final Void v) {
            TraceContextManager.attach(this.ctx);
            callback.onResult(null, null);
        }

        @Override
        public void failed(final Throwable t) {
            TraceContextManager.attach(this.ctx);
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
