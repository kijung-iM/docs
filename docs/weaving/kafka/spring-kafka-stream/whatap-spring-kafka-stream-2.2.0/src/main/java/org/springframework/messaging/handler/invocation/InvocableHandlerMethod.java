package org.springframework.messaging.handler.invocation;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.HttpCall;
import whatap.weaving.v1.Log;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.HashMap;
import java.util.Map;

import static whatap.spring.kafka.stream.WeaveConf.kafka_stream_sink_topic_prefix;

@Weaving
public class InvocableHandlerMethod {

    @Nullable
    public Object invoke(Message<?> message, Object... providedArgs) throws Exception {
        Throwable th = null;
        MessageHeaders map = message.getHeaders();
        String name = kafka_stream_sink_topic_prefix;

        if (map.isEmpty() == false) {
            Object topic = map.get("kafka_receivedTopic");
            if (topic != null) {
                String kafkaReceivedTopic = topic.toString();
                if (kafkaReceivedTopic.length() > 80) {
                    kafkaReceivedTopic = kafkaReceivedTopic.substring(0, 80);
                }
                name = name + kafkaReceivedTopic;
            }
        }
        TraceCtx ctx = Trace.start(name);

        try {
            try {
                if (ctx != null) {
                    Map<String, String> weaveHeader = new HashMap<>();
                    weaveHeader = mtraceHeader(map);
                    HttpCall.mtrace(ctx, weaveHeader);
                } else {
                    HttpCall.mtrace(ctx);
                }
            } catch (Throwable t) {
                Log.println("[kafka] wtap header setting failed");
            }

            return OriginMethod.call();
        } catch (RuntimeException e) {
            th = e;
            throw e;
        } finally {
            try {
                if (ctx != null) {
                    Trace.end(ctx, th);
                }
            } catch (Throwable t) {
            }
        }
    }

    // whatap custom method
    private Map<String, String> mtraceHeader(MessageHeaders map) {
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
