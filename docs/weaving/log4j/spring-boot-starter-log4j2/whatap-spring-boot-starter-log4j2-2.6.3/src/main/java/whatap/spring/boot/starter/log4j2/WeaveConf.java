package whatap.spring.boot.starter.log4j2;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_boot_starter_log4j2 = "title_spring_boot_starter_log4j2";
    public static int log4j2_stack_depth = 50;

    static {
        apply();
        WhatapConf.onModified(title_spring_boot_starter_log4j2, new Runnable() {
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
