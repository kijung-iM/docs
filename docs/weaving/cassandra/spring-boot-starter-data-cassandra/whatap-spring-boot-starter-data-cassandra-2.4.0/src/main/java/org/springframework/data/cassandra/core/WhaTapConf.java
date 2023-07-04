package org.springframework.data.cassandra.core;

import whatap.agent.Configure;
import whatap.agent.data.DataTextAgent;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;
import whatap.lang.conf.ConfObserver;
import whatap.lang.step.MessageStep;
import whatap.util.HashUtil;

public class WhaTapConf {
	public static int cassandra_basetime = 100;
	public static boolean cassandra_profile_query_enabled = false;
//	public static boolean cassandra_show_parameter = false;
	public static int CASSANDRA;
	static {
		try {
			config();
			CASSANDRA = HashUtil.hash("cassandra");
			DataTextAgent.MESSAGE.add(CASSANDRA, "cassandra");
		} catch (Throwable t) {
		}
		ConfObserver.add("cassandra.WhaTapConf", new Runnable() {
			public void run() {
				config();
			}
		});
	}

	protected static void config() {
		Configure conf = Configure.getInstance();
		cassandra_basetime = conf.getInt("cassandra_basetime", 100);
		cassandra_profile_query_enabled = conf.getBoolean("cassandra_profile_query_enabled", false);
//		cassandra_show_parameter = conf.getBoolean("cassandra_show_parameter", false);
	}

	public static void message(String message, long elapsed) {
		TraceContext ctx = TraceContextManager.getLocalContext();
		if (ctx != null) {
			MessageStep step = new MessageStep();
			step.start_time = ctx.getElapsedTime();
			step.hash = CASSANDRA;
			step.time = (int) elapsed;
			step.desc = message;
			ctx.profile.add(step);
		}
	}
}
