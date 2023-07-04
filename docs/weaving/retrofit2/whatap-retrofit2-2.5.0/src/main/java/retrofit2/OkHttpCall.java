package retrofit2;

import okhttp3.HttpUrl;
import okhttp3.Request;
import whatap.agent.Logger;
import whatap.agent.api.trace.TxHttpC;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.HttpcContext;

import java.io.IOException;

@Weaving
public abstract class OkHttpCall<T> {

    private volatile boolean canceled;

    public synchronized Request request() {
        return OriginMethod.call();
    }

    public retrofit2.Response<T> execute() throws IOException {
        Request req = request();

        retrofit2.Response<T> resp = null;
        HttpcContext stat = null;
        Throwable thr = null;
        try {
            if (req != null) {
                try {
                    HttpUrl u = req.url();
                    stat = TxHttpC.startNonBlockHttpc(u.host(), u.port(), u.uri().getPath());
                } catch (Throwable t) {
                    try {
                        Logger.println("retrofit-2.5.0", 10, t.getMessage());
                    } catch (Throwable ignore) {
                    }
                }
            }

            try {
                resp = OriginMethod.call();
            } catch (Throwable e) {
                thr = e;
                throw e;
            }
        } finally {
            if (!this.canceled) {
                try {
                    if (resp != null) {
                        TxHttpC.endHttpc(stat, resp.code(), resp.message(), thr);
                    }
                } catch (Throwable t) {
                    try {
                        Logger.println("retrofit-2.5.0", 10, t.getMessage());
                    } catch (Throwable ignore) {
                    }
                }
            }
        }
        return resp;
    }
}
