package org.apache.tomcat.dbcp.dbcp;

import org.apache.tomcat.dbcp.pool.ObjectPool;
import org.apache.tomcat.dbcp.pool.PoolableObjectFactory;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Log;

@Weaving
abstract public class PoolableConnectionFactory implements PoolableObjectFactory {

	public void activateObject(Object obj) throws Exception {
		OriginMethod.call();

		if (WConf.dbcp_refresh_enabled) {
			if (obj instanceof PoolableConnection) {
				PoolableConnection c = (PoolableConnection) obj;
				if (c._start_time_ > 0) {
					long now = System.currentTimeMillis();
					long duration = now - c._start_time_;
					if (duration > WConf.dbcp_refresh_expired && now > WConf.dbcp_refresh_next) {
						WConf.dbcp_refresh_next = now + WConf.dbcp_refresh_pause;
						Log.println("dbcp connection expired hash=" + System.identityHashCode(obj) + " elapsed="
								+ (duration / 1000) + "sec");
						final ObjectPool pool = getPool();
						
						RecoverThread.getInstance().add(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(1000);
									Log.println("dbcp add new connection");
									pool.addObject();
								} catch (Exception e) {
									Log.println("dbcp " + e.getMessage());
								}
							}
						});
						
						throw new Exception("dbcp connection expired");
					}
					if (WConf.debug_dbcp_refresh_enabled) {
						Log.println("dbcp getConnection hash=" + System.identityHashCode(obj) + " elapsed="
								+ (duration / 1000) + "sec");
					}
				} else {
					if (WConf.debug_dbcp_refresh_enabled) {
						Log.println("dbcp getConnection hash=" + System.identityHashCode(obj) + " no start-time");
					}
				}
			}
		}
	}

	abstract public ObjectPool getPool();

	static {
		Log.yellow("dbcp_refresh_enabled=" + WConf.dbcp_refresh_enabled);
		Log.yellow("debug_dbcp_refresh_enabled=" + WConf.debug_dbcp_refresh_enabled);
	}

}