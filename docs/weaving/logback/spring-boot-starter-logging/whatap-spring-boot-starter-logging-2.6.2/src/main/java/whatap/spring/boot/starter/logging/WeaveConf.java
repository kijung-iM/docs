package whatap.spring.boot.starter.logging;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_boot_starter_logging = "spring_boot_starter_logging";
    public static int logback_stack_depth = 50;

    static {
        apply();
        WhatapConf.onModified(title_spring_boot_starter_logging, new Runnable() {
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
