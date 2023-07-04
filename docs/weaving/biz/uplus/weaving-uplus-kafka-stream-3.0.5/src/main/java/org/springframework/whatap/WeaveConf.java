package org.springframework.whatap;

import whatap.agent.Configure;
import whatap.lang.conf.ConfObserver;

public class WeaveConf {

    // source
    public static String source_host = "kafka-stream";
    public static int source_port = 0;
    public static String source_channel_prefix = "[kafka]";

    // sink
    public static String sink_prefix = "[kafka]";
    public static String sink_topic = "";

    static {
        try {
            apply();
        } catch (Throwable t) {
        }
        ConfObserver.add("kafkaStream.WhaTapConf", new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        Configure conf = Configure.getInstance();

        // source
        source_host = conf.getValue("source_host", "kafka-stream");
        source_port = conf.getInt("source_port", 0);
        source_channel_prefix = conf.getValue("source_channel_prefix", "[kafka]");

        // sink
        sink_prefix = conf.getValue("sink_prefix", "[kafka]");
        sink_topic = conf.getValue("sink_topic", "");
    }

}
