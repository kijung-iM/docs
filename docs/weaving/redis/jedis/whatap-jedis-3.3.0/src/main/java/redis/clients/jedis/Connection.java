package redis.clients.jedis;

import redis.clients.jedis.commands.ProtocolCommand;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.jedis.WeaveConf;
import whatap.weaving.v1.Sql;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

@Weaving
public class Connection {

    private JedisSocketFactory jedisSocketFactory;

    public void sendCommand(final ProtocolCommand cmd, final byte[]... args) {
        TraceCtx ctx = null;
        long stime = 0;
        if (args.length > 0) {
            ctx = Trace.context();
            stime = System.nanoTime() / 1000000;
        }
        try {
            OriginMethod.call();
        } finally {
            if (ctx != null) {
                long etime = System.nanoTime() / 1000000;
                int elapsed = (int) (etime - stime);
                if (elapsed >= WeaveConf.jedis_basetime) {
                    String dbHostStr = null;
                    if (jedisSocketFactory != null) {
                        dbHostStr = jedisSocketFactory.getHost() + ":" + jedisSocketFactory.getPort();
                    }

                    String queryStr = String.valueOf(cmd);

                    Trace.step(ctx, "Redis.Jedis " + dbHostStr, null, elapsed, 0);
                    Sql.trace(ctx, dbHostStr, queryStr, null, elapsed, null);
                }
            }
        }
    }
}
