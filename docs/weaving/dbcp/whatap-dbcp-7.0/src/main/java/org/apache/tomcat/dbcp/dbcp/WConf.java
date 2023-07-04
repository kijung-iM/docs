package org.apache.tomcat.dbcp.dbcp;

import whatap.weaving.v1.WhatapConf;

public class WConf {
	public static boolean dbcp_refresh_enabled=true;
	public static boolean debug_dbcp_refresh_enabled=false;
	public static long dbcp_refresh_next = System.currentTimeMillis();
	public static long dbcp_refresh_expired = 24 * 3600 * 1000L;
	public static long dbcp_refresh_pause = 10000;
	
	
	protected static boolean getBoolean(String key, boolean def) {
		String v = WhatapConf.get(key);
		if(v==null|| v.length()==0)
			return def;
		return "true".equalsIgnoreCase(v);
	}
	protected static void apply() {
		dbcp_refresh_enabled=getBoolean("dbcp_refresh_enabled", true);
		debug_dbcp_refresh_enabled=getBoolean("debug_dbcp_refresh_enabled", false);
		dbcp_refresh_expired = WhatapConf.getLong("dbcp_refresh_expired", 24 * 3600 * 1000L);
		if (dbcp_refresh_expired <= 0) {
			dbcp_refresh_expired = 24 * 3600 * 1000L;
		}
		dbcp_refresh_pause = WhatapConf.getLong("dbcp_refresh_pause", 10000);
	}

	static {
		apply();
		WhatapConf.onModified("dbcp_whatap", new Runnable() {
			public void run() {
				apply();
			}		
		});
	}
	public static void main(String[] args) {
		System.out.println(24 * 3600 * 1000L);
	}
}
