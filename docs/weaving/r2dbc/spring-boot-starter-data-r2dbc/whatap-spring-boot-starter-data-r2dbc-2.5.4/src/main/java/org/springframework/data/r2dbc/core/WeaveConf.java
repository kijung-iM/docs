package org.springframework.data.r2dbc.core;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_data_r2dbc = "spring-boot-starter-data-r2dbc";
    public static boolean r2dbc_show_parameter = false;
    public static int r2dbc_basetime = 100;

    static {
        apply();
        WhatapConf.onModified(title_spring_data_r2dbc, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        r2dbc_basetime = WhatapConf.getInt("r2dbc_basetime", 100);
        r2dbc_show_parameter = WhatapConf.getBoolean("r2dbc_show_parameter", false);
    }
}
