package whatap.spring.boot.websocket.sockjs;

import whatap.weaving.v1.WhatapConf;

public class WeaveConf {

    public static boolean websocket_sockjs_trace_enabled = false;
    public static String  websocket_sockjs_step_title = "websocket_sockjs";
    public static int     websocket_sockjs_basetime = 100;
    public static boolean websocket_sockjs_profile_enabled = false;
    public static boolean websocket_sockjs_trace_exception = true;

    static {
        try {
            apply();
        } catch (Throwable t) {
        }
        WhatapConf.onModified(websocket_sockjs_step_title, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        websocket_sockjs_trace_enabled = WhatapConf.getBoolean("websocket_sockjs_trace_enabled", false);

        String weaveTitle = WhatapConf.get("websocket_sockjs_step_title");
        if (weaveTitle != null && weaveTitle.length() > 0) websocket_sockjs_step_title = weaveTitle;

        websocket_sockjs_basetime = WhatapConf.getInt("websocket_sockjs_basetime", 100);
        websocket_sockjs_profile_enabled = WhatapConf.getBoolean("websocket_sockjs_profile_enabled", false);
        websocket_sockjs_trace_exception = WhatapConf.getBoolean("websocket_sockjs_trace_exception", true);
    }

}
