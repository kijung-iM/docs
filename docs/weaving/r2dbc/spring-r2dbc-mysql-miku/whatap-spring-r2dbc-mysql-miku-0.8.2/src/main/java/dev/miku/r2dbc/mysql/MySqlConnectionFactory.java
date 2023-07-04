package dev.miku.r2dbc.mysql;

import io.netty.channel.unix.DomainSocketAddress;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

@Weaving
public class MySqlConnectionFactory {

    public static String weaveDatabase;
    public static InetSocketAddress weaveAddress;

    public static MySqlConnectionFactory from(MySqlConnectionConfiguration configuration) {
        SocketAddress tmpAddress;
        if (configuration.isHost()) {
            tmpAddress = InetSocketAddress.createUnresolved(configuration.getDomain(), configuration.getPort());
        } else {
            tmpAddress = new DomainSocketAddress(configuration.getDomain());
        }
        SocketAddress socketAddress = tmpAddress;
        if (socketAddress instanceof InetSocketAddress) {
            weaveAddress = (InetSocketAddress) socketAddress;
            weaveDatabase = configuration.getDatabase();
        }

        return OriginMethod.call();
    }
}
