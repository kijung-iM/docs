package whatap.spring.kafka.stream;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {

    // source
    public static String kafka_stream_source_host = "kafka-stream";
    public static int kafka_stream_source_port = 0;
    public static String kafka_stream_source_channel_prefix = "[kafka-channel]";

    // sink
    public static String kafka_stream_sink_topic_prefix = "[topic]";

    static {
        try {
            apply();
        } catch (Throwable t) {
        }
        WhatapConf.onModified("kafkaStream.WhaTapConf", new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        // source
        String sourceHost = WhatapConf.get("kafka_stream_source_host");
        if (sourceHost != null && sourceHost.length() > 0) kafka_stream_source_host = sourceHost;

        kafka_stream_source_port = WhatapConf.getInt("kafka_stream_source_port", 0);

        String sourceChannelPrefix = WhatapConf.get("kafka_stream_source_channel_prefix");
        if (sourceChannelPrefix != null && sourceChannelPrefix.length() > 0) kafka_stream_source_channel_prefix = sourceChannelPrefix;

        // sink
        String sinkTopic = WhatapConf.get("kafka_stream_sink_topic_prefix");
        if (sinkTopic != null && sinkTopic.length() > 0) kafka_stream_sink_topic_prefix = sinkTopic;
    }

}
