package whatap.v1;

public class WhatapConf {
	public static String get(String key) {
		return null;
	}
	public static int getInt(String key, int def) {
		return def;
	}
	public static long getLong(String key, long def) {
		return def;
	}
	public static float getFloat(String key, float def) {
		return def;
	}
	
	public static void onModified(String id, Runnable r) {
	}
}
