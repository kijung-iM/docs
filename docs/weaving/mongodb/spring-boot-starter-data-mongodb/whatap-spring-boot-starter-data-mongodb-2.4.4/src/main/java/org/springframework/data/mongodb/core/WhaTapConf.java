package org.springframework.data.mongodb.core;

import whatap.agent.Configure;
import whatap.agent.data.DataTextAgent;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;
import whatap.lang.conf.ConfObserver;
import whatap.lang.step.MessageStep;
import whatap.util.HashUtil;

public class WhaTapConf {
    public static int mongodb_basetime = 100;
    public static boolean mongodb_show_parameter = false;
    public static int MONGODB;

    static {
        try {
            config();
            MONGODB = HashUtil.hash("mongodb");
            DataTextAgent.MESSAGE.add(MONGODB, "mongodb");
        } catch (Throwable ignore) {
        }
        ConfObserver.add("mongodb.WhaTapConf", new Runnable() {
            public void run() {
                config();
            }
        });
    }

    protected static void config() {
        Configure conf = Configure.getInstance();
        mongodb_basetime = conf.getInt("mongodb_basetime", 100);
        mongodb_show_parameter = conf.getBoolean("mongodb_show_parameter", false);
    }

    public static void message(String message, long elapsed) {
        TraceContext ctx = TraceContextManager.getLocalContext();
        if (ctx != null) {
            MessageStep step = new MessageStep();
            step.start_time = ctx.getElapsedTime();
            step.hash = MONGODB;
            step.time = (int) elapsed;
            step.desc = message;
            ctx.profile.add(step);
        }
    }
}
