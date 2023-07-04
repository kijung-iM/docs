package org.springframework.integration.channel;

import org.springframework.messaging.Message;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.HttpCall;
import whatap.weaving.v1.HttpCallCtx;

import static whatap.spring.kafka.stream.WeaveConf.*;

@Weaving
public abstract class AbstractMessageChannel {

    private volatile String fullChannelName;

    /**
     * Send a message on this channel. If the channel is at capacity, this
     * method will block until either the timeout occurs or the sending thread
     * is interrupted. If the specified timeout is 0, the method will return
     * immediately. If less than zero, it will block indefinitely (see
     * {@link #send(Message)}).
     * @param messageArg the Message to send
     * @param timeout the timeout in milliseconds
     * @return <code>true</code> if the message is sent successfully,
     * <code>false</code> if the message cannot be sent within the allotted
     * time or the sending thread is interrupted.
     */
//    @Override // NOSONAR complexity
    public boolean send(Message<?> messageArg, long timeout) {
        HttpCallCtx weaveKafkaCall = HttpCall.start(kafka_stream_source_host, kafka_stream_source_port, kafka_stream_source_channel_prefix + this.fullChannelName);
        try {
            return OriginMethod.call();
        } finally {
            try {
                if (weaveKafkaCall != null) {
                    HttpCall.end(weaveKafkaCall, 0, null, null);
                }
            } catch (Throwable t) {
            }
        }
    }

}
