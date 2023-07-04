package whatap.jedis;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_jedis = "jedis";
    public static int jedis_basetime = 100;

    static {
        apply();
        WhatapConf.onModified(title_jedis, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        jedis_basetime = WhatapConf.getInt("jedis_basetime", 100);
    }

}
