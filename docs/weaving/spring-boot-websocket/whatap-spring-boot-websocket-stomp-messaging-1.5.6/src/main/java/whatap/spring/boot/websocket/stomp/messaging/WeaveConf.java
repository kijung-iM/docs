package whatap.spring.boot.websocket.stomp.messaging;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {

    public static boolean websocket_trace_enabled = false;
    public static String websocket_step_title = "websocket_stomp";
    public static int websocket_basetime = 100;
    public static boolean websocket_profile_enabled = false;
    public static boolean websocket_trace_exception = true;

    static {
        try {
            apply();
        } catch (Throwable t) {
        }
        WhatapConf.onModified(websocket_step_title, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        websocket_trace_enabled = WhatapConf.getBoolean("websocket_trace_enabled", false);

        String weaveTitle = WhatapConf.get("websocket_step_title");
        if (weaveTitle != null && weaveTitle.length() > 0) websocket_step_title = weaveTitle;

        websocket_basetime = WhatapConf.getInt("websocket_basetime", 100);
        websocket_profile_enabled = WhatapConf.getBoolean("websocket_profile_enabled", false);
        websocket_trace_exception = WhatapConf.getBoolean("websocket_trace_exception", true);
    }

}
