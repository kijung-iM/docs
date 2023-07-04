package io.lettuce.core;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {

    public static String title_spring_data_redis = "spring-boot-starter-data-redis";
    public static int redis_lettuce_basetime = 100;

    static {
        apply();
        WhatapConf.onModified(title_spring_data_redis, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        redis_lettuce_basetime = WhatapConf.getInt("redis_lettuce_basetime", 100);
    }
}
