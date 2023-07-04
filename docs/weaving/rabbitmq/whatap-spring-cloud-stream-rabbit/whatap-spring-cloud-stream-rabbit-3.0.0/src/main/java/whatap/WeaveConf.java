package whatap;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_cloud_stream_rabbit = "spring-cloud-stream-rabbit";

    static {
        apply();
        WhatapConf.onModified(title_spring_cloud_stream_rabbit, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
    }
}
