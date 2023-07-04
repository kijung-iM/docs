package okhttp3;

import org.jetbrains.annotations.NotNull;
import whatap.agent.Logger;
import whatap.agent.api.trace.TxHttpC;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
abstract public class RealCall {
    abstract public Request request();

    @NotNull
    public Response execute() {
        Request req = request();
        Response resp = null;
        Object stat = null;
        Throwable thr = null;
        try {
            if (req != null) {
                try {
                    HttpUrl u = req.url();
                    stat = TxHttpC.startHttpc(u.host(), u.port(), u.uri().getPath());
                } catch (Throwable t) {
                    try {
                        Logger.println("okhttp-4.0.0", 10, t.getMessage());
                    } catch (Throwable tt) {
                    }
                }
            }
            resp = OriginMethod.call();
        } finally {
            try {
                TxHttpC.endHttpc(stat, resp.code(), resp.message(), thr);
            } catch (Throwable t) {
                try {
                    Logger.println("okhttp-4.0.0", 10, t.getMessage());
                } catch (Throwable tt) {
                }
            }
        }
        return resp;
    }
}
