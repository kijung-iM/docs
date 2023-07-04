package whatap.logback.core;

import whatap.weaving.v1.WhatapConf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaveConf {
    public static String title_logback_core_appender = "logback_core_appender";
    public static String logback_main_category = "AppLog";
    public static int logback_stack_depth = 50;
    public static List<String> logbackCategoryList = new ArrayList<String>();
    public static boolean hasLogbackCategoryList = false;
    public static boolean logback_save_console = false;
    public static String logback_save_category_list;

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
        String logbackMain = WhatapConf.get("logback_main_category");
        if (logbackMain != null && logbackMain.length() > 0) logback_main_category = logbackMain;

        logback_stack_depth = WhatapConf.getInt("logback_stack_depth", 50);
        if (logback_stack_depth <= 0) logback_stack_depth = 0;

        logback_save_console = WhatapConf.getBoolean("logback_save_console", false);

        String logback_save_category = WhatapConf.get("logback_save_category_list");
        if (logback_save_category != null && logback_save_category.length() > 0) {
            String[] categories = logback_save_category.split(",");
            logbackCategoryList.clear();
            logbackCategoryList.addAll(Arrays.asList(categories));
            hasLogbackCategoryList = true;
        } else {
            hasLogbackCategoryList = false;
        }
    }
}
