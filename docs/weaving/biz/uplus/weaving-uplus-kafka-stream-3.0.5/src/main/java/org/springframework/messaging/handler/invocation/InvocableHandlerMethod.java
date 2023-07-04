package org.springframework.messaging.handler.invocation;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import whatap.agent.Logger;
import whatap.agent.api.trace.TxTrace;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.whatap.WeaveConf.sink_prefix;
import static org.springframework.whatap.WeaveConf.sink_topic;

@Weaving
public class InvocableHandlerMethod {

    @Nullable
    public Object invoke(Message<?> message, Object... providedArgs) throws Exception {
        Throwable th = null;
        MessageHeaders map = message.getHeaders();
        String name = sink_topic;
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
        TraceContext ctx = TxTrace.startTx(sink_prefix + name);

        try {
            try {
                if (ctx != null) {
                    String weaveV;
                    weaveV = (String) map.get("x-wtap-mst");
                    if (weaveV != null) ctx.setTransferMTID_CALLERTX(weaveV);

                    String weaveW;
                    weaveW = (String) map.get("x-wtap-po");
                    if (weaveW != null) ctx.setCallerPOID(weaveW);

                    String weaveX;
                    weaveX = (String) map.get("x-wtap-sp1");
                    if (weaveX != null) ctx.setTransferSPEC_URL1(weaveX);

                    String weaveXF = (String) map.get("X-Forwarded-Attribute");
                    String gtid = "";
                    if (weaveXF != null) {
                        JSONObject jsonObject = new JSONObject(weaveXF);
                        gtid = jsonObject.optString("gtid", "");
                        if (gtid.length() > 0) {
                            ctx.customTrace(gtid);
                        }
                    }
                }
            } catch (Throwable t) {
                Logger.println("[kafka] wtap header setting failed");
            }
            return OriginMethod.call();
        } catch (RuntimeException e) {
            th = e;
            throw e;
        } finally {
            try {
                if (ctx != null) {
                    TxTrace.endTx(ctx, th);
                }
            } catch (Throwable ignore) {
                Logger.println("[kafka] endTx failed");
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 1. Origin Method error --> TxTrace.name
         * 2. map.isEmpty --> name == [kafka]
         * 3. kafka_receivedTopic == null --> name == [kafka]
         * 4. kafka_receivedTopic.length() > 80 --> substring(0, 80)
         */
        Map<String, Object> map = new HashMap<>();
//        map.put("kafka_receivedTopic", "topic_test asdkjelwkjvklzlkvjclkjlkjqwoijoiasjdf;ksjlxkczjv;lkjasdlkjlkjeijfkljlkjlkvjlkj;laskdjf;lksjdf;iojwefkjv;lkjzxc,mvzlkjwaoijrekgj;alkjflskjdlaksjd");
//        map.put("kafka_receivedTopic", null);

        String name = "";
        String prefix = "[kafka]";

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
        System.out.println("TxTrace.name: " + prefix + name);
    }
}
