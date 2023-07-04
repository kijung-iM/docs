package whatap.logback.core;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String track_logsink_record = "track_logsink_record";
    public static int logback_stack_depth = 50;

    static {
        apply();
        WhatapConf.onModified(track_logsink_record, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        logback_stack_depth = WhatapConf.getInt("logback_stack_depth", 50);
        if (logback_stack_depth <= 0) logback_stack_depth = 0;
    }
}
