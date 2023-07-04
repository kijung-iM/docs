package org.apache.tomcat.dbcp.dbcp;

import java.sql.Connection;

import org.apache.tomcat.dbcp.pool.ObjectPool;

import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Log;

@Weaving
abstract public class PoolableConnection {
	public long _start_time_;

	public PoolableConnection(Connection conn, ObjectPool pool) {
		this._start_time_ = System.currentTimeMillis();
		
		if (WConf.debug_dbcp_refresh_enabled) {
			Log.println("dbcp Connection created hash=" + System.identityHashCode(this));
		}
	}

	public PoolableConnection(Connection conn, ObjectPool pool, AbandonedConfig config) {
		this._start_time_ = System.currentTimeMillis();
		Log.println("dbcp Connection created hash=" + System.identityHashCode(this));
	}
}
