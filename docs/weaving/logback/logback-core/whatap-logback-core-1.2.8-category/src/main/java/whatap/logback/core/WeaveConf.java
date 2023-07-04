package whatap.logback.core;

import whatap.weaving.v1.WhatapConf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaveConf {
    public static String title_logback_core_appender = "logback_core_appender";
    public static String logback_main_appender = "AppLog";
    public static int logback_stack_depth = 50;
    public static List<String> logbackAppenderList = new ArrayList<String>();
    public static boolean hasLogbackList = false;

    static {
        apply();
        WhatapConf.onModified(title_logback_core_appender, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        logback_main_appender = WhatapConf.get("logback_main_appender");
        if (logback_main_appender == null || logback_main_appender.length() == 0) {
            logback_main_appender = "AppLog";
        }
        logback_stack_depth = WhatapConf.getInt("logback_stack_depth", 50);
        if (logback_stack_depth <= 0) logback_stack_depth = 0;
        String logback_save_appender = WhatapConf.get("logback_save_appender_list");
        if (logback_save_appender != null && logback_save_appender.length() > 0) {
            String[] appender = logback_save_appender.split(",");
            logbackAppenderList.clear();
            logbackAppenderList.addAll(Arrays.asList(appender));
            hasLogbackList = true;
        } else {
            hasLogbackList = false;
        }
    }
}
