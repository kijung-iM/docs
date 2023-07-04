package whatap.r2dbc.mysql.jasync.util;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_spring_r2dbc_mysql_jasync = "spring-r2dbc-mysql-jasync";

    static {
        apply();
        WhatapConf.onModified(title_spring_r2dbc_mysql_jasync, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
    }
}
