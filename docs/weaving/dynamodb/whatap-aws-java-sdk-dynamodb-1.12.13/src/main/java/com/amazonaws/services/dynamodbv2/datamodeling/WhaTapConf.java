package com.amazonaws.services.dynamodbv2.datamodeling;

import whatap.agent.Configure;
import whatap.agent.data.DataTextAgent;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;
import whatap.lang.conf.ConfObserver;
import whatap.lang.step.MessageStep;
import whatap.util.HashUtil;

public class WhaTapConf {
	public static int dynamodb_basetime = 100;
	public static boolean dynamodb_show_parameter = false;
	public static boolean dynamodb_show_query = true;
	public static int DYNAMODB;
	static {
		try {
			config();
			DYNAMODB = HashUtil.hash("dynamodb");
			DataTextAgent.MESSAGE.add(DYNAMODB, "dynamodb");
		} catch (Throwable t) {
		}
		ConfObserver.add("dynamodb.WhaTapConf", new Runnable() {
			public void run() {
				config();
			}
		});
	}

	protected static void config() {
		Configure conf = Configure.getInstance();
		dynamodb_basetime = conf.getInt("dynamodb_basetime", 100);
		dynamodb_show_parameter = conf.getBoolean("dynamodb_show_parameter", false);
		dynamodb_show_query = conf.getBoolean("dynamodb_show_query", true);
	}

	public static void message(String message, long elapsed) {
		TraceContext ctx = TraceContextManager.getLocalContext();
		if (ctx != null) {
			MessageStep step = new MessageStep();
			step.start_time = ctx.getElapsedTime();
			step.hash = DYNAMODB;
			step.time = (int) elapsed;
			step.desc = message;
			ctx.profile.add(step);
		}
	}
}
