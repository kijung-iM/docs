package whatap.apache.logging.log4j;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_apache_logging_log4j2 = "title_apache_logging_log4j2";
    public static int log4j2_stack_depth = 50;

    static {
        apply();
        WhatapConf.onModified(title_apache_logging_log4j2, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        log4j2_stack_depth = WhatapConf.getInt("log4j2_stack_depth", 50);
        if (log4j2_stack_depth <= 0) log4j2_stack_depth = 0;
    }
}
