package com.rabbitmq.client.impl;

import com.rabbitmq.client.*;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Weaving
public abstract class ChannelN extends AMQChannel implements Channel {

    public void basicPublish(String exchange, String routingKey, boolean mandatory, boolean immediate, AMQP.BasicProperties props, byte[] body) throws IOException {
        TraceCtx ctx = Trace.context();

        // build header
        try {
            HashMap<String, Object> headers = new HashMap<>(props.getHeaders());
            Map<String, String> header = HttpCall.mtrace(ctx);
            if (header != null) {
                headers.putAll(header);
                props = props.builder().headers(headers).build();
            }
        } catch (Throwable ignore) {}

        // build service name, step message
        StringBuilder sb = new StringBuilder();
        boolean hasLongRoutingKey = false;
        String messageRoutingKey = "";
        sb.append("[RabbitMQ]");
        if (exchange != null && exchange.length() > 0) {
            sb.append(" exchange:").append(exchange);
            if (routingKey != null && routingKey.length() > 0) {
                sb.append(" routingKey:").append(routingKey);
            }
        } else if (routingKey != null && routingKey.length() > 0) {
            if (routingKey.length() > 80) {
                hasLongRoutingKey = true;
                messageRoutingKey = routingKey;
                messageRoutingKey = messageRoutingKey.substring(0, 21);
                sb.append(" routingKey:").append(messageRoutingKey);
            } else {
                sb.append(" routingKey:").append(routingKey);
            }
        } else {
            sb.append(" binding:").append("unKnown");
        }

        // step
        Trace.step(sb.toString(), hasLongRoutingKey ? "routingKey:" + routingKey : messageRoutingKey, 0, 0);

        // start remote call
        RemoteCallCtx rCtx = RemoteCall.start(getConnection().getAddress().getHostAddress(), getConnection().getPort(), getConnection().toString(), "amqp");

        try {
            OriginMethod.call();
        } finally {
            if (ctx != null) {
                RemoteCall.end(rCtx, null);
                Trace.end(ctx, null);
            }
        }
    }

}
