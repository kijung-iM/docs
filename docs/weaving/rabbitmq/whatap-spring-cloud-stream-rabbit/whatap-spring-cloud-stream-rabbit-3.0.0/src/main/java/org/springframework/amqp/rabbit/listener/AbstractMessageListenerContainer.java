package org.springframework.amqp.rabbit.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.messaging.MessageHeaders;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.HttpCall;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.HashMap;
import java.util.Map;

@Weaving
public class AbstractMessageListenerContainer {

    protected void executeListener(Channel channel, Object data) {
        TraceCtx ctx = Trace.context();

        Throwable th = null;
        String serviceName = "rabbit-stream";
        MessageHeaders messageHeaders = null;
        Map<String, Object> weaveHeaders = new HashMap<>();

        try {
            boolean hasLongRoutingKey = false;
            String messageRoutingKey = "";
            String receivedExchange = null;
            String receivedRoutingKey = null;
            String consumerQueue = null;

            if (data instanceof Message) {
                Message message = (Message) data;

                weaveHeaders = message.getMessageProperties().getHeaders();
                MessageProperties messageProperties = message.getMessageProperties();

                if (messageProperties != null) {
                    receivedExchange = messageProperties.getReceivedExchange();
                    receivedRoutingKey = messageProperties.getReceivedRoutingKey();
                    consumerQueue = messageProperties.getConsumerQueue();

                    StringBuilder sb = new StringBuilder();
                    sb.append("[RabbitMQ]");
                    if (receivedExchange != null && receivedExchange.length() > 0) {
                        sb.append(" exchange:").append(receivedExchange);
                        if (receivedRoutingKey != null && receivedRoutingKey.length() > 0) {
                            sb.append(" routingKey:").append(receivedRoutingKey);
                        }
                    } else if (receivedRoutingKey != null && receivedRoutingKey.length() > 0) {
                        if (receivedRoutingKey.length() > 80) {
                            hasLongRoutingKey = true;
                            messageRoutingKey = receivedRoutingKey;
                            messageRoutingKey = messageRoutingKey.substring(0, 21);
                            sb.append(" routingKey:").append(messageRoutingKey);
                        } else {
                            sb.append(" routingKey:").append(receivedRoutingKey);
                        }
                    } else if (consumerQueue != null && consumerQueue.length() > 0) {
                        sb.append(" consumerQueue:").append(consumerQueue);
                    } else {
                        sb.append(" consumer:").append("unKnown");
                    }
                    serviceName = sb.toString();
                }

                ctx = Trace.start(serviceName);
                if (ctx != null) {
                    if (hasLongRoutingKey) {
                        messageRoutingKey = "routingKey:" + receivedRoutingKey;
                    }
                    Trace.step(ctx, "(channel no." + channel.getChannelNumber() + ") " + serviceName, messageRoutingKey, 0, 0);
                }
            } else if (data instanceof org.springframework.messaging.Message) {
                org.springframework.messaging.Message message = (org.springframework.messaging.Message) data;
                messageHeaders = message.getHeaders();
                ctx = Trace.start(serviceName);
            }

            if (weaveHeaders != null) {
                Map<String, String> weaveHeader;
                weaveHeader = weaveAmqpHeader(weaveHeaders);
                HttpCall.mtrace(ctx, weaveHeader);
            } else if (messageHeaders != null) {
                Map<String, String> weaveHeader;
                weaveHeader = weaveMessageHeader(messageHeaders);
                HttpCall.mtrace(ctx, weaveHeader);
            } else {
                HttpCall.mtrace(ctx);
            }
        } catch (Throwable ignore) {
        }

        try {
            OriginMethod.call();
        } finally {
            try {
                if (ctx != null) {
                    Trace.end(ctx, th);
                }
            } catch (Throwable ignore) {
            }
        }
    }

    private Map<String, String> weaveMessageHeader(MessageHeaders map) {
        Map<String, String> weaveHeader = new HashMap<>();
        String weaveV;
        weaveV = (String) map.get("x-wtap-mst");
        if (weaveV != null) weaveHeader.put("x-wtap-mst", weaveV);

        String weaveW;
        weaveW = (String) map.get("x-wtap-po");
        if (weaveW != null) weaveHeader.put("x-wtap-po", weaveW);

        String weaveX;
        weaveX = (String) map.get("x-wtap-sp1");
        if (weaveX != null) weaveHeader.put("x-wtap-sp1", weaveX);

        return weaveHeader;
    }

    private Map<String, String> weaveAmqpHeader(Map<String, Object> map) {
        Map<String, String> weaveHeader = new HashMap<>();
        String weaveV;
        weaveV = (String) map.get("x-wtap-mst");
        if (weaveV != null) weaveHeader.put("x-wtap-mst", weaveV);

        String weaveW;
        weaveW = (String) map.get("x-wtap-po");
        if (weaveW != null) weaveHeader.put("x-wtap-po", weaveW);

        String weaveX;
        weaveX = (String) map.get("x-wtap-sp1");
        if (weaveX != null) weaveHeader.put("x-wtap-sp1", weaveX);

        return weaveHeader;
    }
}
