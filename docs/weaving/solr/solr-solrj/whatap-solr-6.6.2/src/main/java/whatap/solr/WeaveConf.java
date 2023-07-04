package whatap.solr;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_solr_solrj = "solr_solrj";
    public static String title_solr_core = "solr_core";
    public static int solr_basetime = 100;
    public static int solr_params_limit = 100;
    public static boolean solr_profile_enabled = false;

    static {
        apply();
        WhatapConf.onModified(title_solr_solrj, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        solr_basetime = WhatapConf.getInt("solr_basetime", 100);
        if (solr_basetime <= 0) solr_basetime = 0;
        solr_profile_enabled = WhatapConf.getBoolean("solr_profile_enabled", false);
        solr_params_limit = WhatapConf.getInt("solr_params_limit", 100);
        if (solr_params_limit <= 0) solr_params_limit = 0;
    }
}
