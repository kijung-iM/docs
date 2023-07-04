package whatap.r2dbc.mysql.miku.util;

import dev.miku.r2dbc.mysql.MySqlResult;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import whatap.weaving.v1.Sql;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.net.InetSocketAddress;
import java.util.function.Consumer;

import static dev.miku.r2dbc.mysql.MySqlConnectionFactory.weaveAddress;
import static dev.miku.r2dbc.mysql.MySqlConnectionFactory.weaveDatabase;

public class WeaveUtil {

    public static Flux<MySqlResult> trace(TraceCtx ctx, long stime, Flux<MySqlResult> orgResult, String sql) {
        if (orgResult != null) {
            if (ctx != null) {
                Trace.attach(ctx);
            }
            TraceCtx finalCtx = ctx;
            return orgResult
                    .doOnSubscribe(execute(ctx, stime, sql))
                    .doFinally((type) -> Trace.end(finalCtx, null));
        }
        return orgResult;
    }

    private static Consumer<Subscription> execute(TraceCtx ctx, long stime, String sql) {
        return (subscription) -> {
            InetSocketAddress socketAddress = weaveAddress;
            if (socketAddress != null) {
                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);
                Sql.trace(ctx, weaveAddress.getHostName() + ":" + weaveAddress.getPort() + "/" + weaveDatabase, sql, null, elapsed, null);
            }
        };
    }

}
