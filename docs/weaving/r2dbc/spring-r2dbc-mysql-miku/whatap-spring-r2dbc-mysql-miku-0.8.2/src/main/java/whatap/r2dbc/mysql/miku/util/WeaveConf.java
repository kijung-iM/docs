package whatap.r2dbc.mysql.miku.util;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_r2dbc_mysql_miku = "spring-r2dbc-mysql-miku";

    static {
        apply();
        WhatapConf.onModified(title_spring_r2dbc_mysql_miku, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
    }
}
