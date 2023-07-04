package org.springframework.data.cassandra.core;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.cassandra.core.cql.QueryOptions;
import org.springframework.data.cassandra.core.query.Query;

import com.datastax.oss.driver.api.core.cql.Statement;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class CassandraTemplate {
	public boolean update(Query query, org.springframework.data.cassandra.core.query.Update update,
			Class<?> entityClass) throws DataAccessException {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("update(query)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" ").append(query);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public <T> EntityWriteResult<T> update(T entity, UpdateOptions options) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("update(entity)");			
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public WriteResult delete(Object entity, QueryOptions options) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("delete(entity)");
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}
	
	public boolean delete(Query query, Class<?> entityClass) throws DataAccessException {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("delete(query)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" ").append(query);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public boolean deleteById(Object id, Class<?> entityClass) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("deleteById(Object)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" id=").append(id);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public <T> EntityWriteResult<T> insert(T entity, InsertOptions options) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("insert(entity)");
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public <T> T selectOneById(Object id, Class<T> entityClass) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("selectOneById(Object)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" id=").append(id);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}
	
	public <T> List<T> select(Query query, Class<T> entityClass) throws DataAccessException {		
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("select(query)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" ").append(query);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public <T> List<T> select(Statement<?> statement, Class<T> entityClass) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("select(statement)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" ").append(statement);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public long count(Query query, Class<?> entityClass) throws DataAccessException {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("count(Query)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" query=").append(query);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public boolean exists(Object id, Class<?> entityClass) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {return OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("exists(Object)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" id=").append(id);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

	public void truncate(Class<?> entityClass) {
		long stime = System.nanoTime() / 1000000;
		Throwable thr = null;
		try {
			OriginMethod.call();
		} catch (RuntimeException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				StringBuffer sb = new StringBuffer();
				sb.append("truncate(Class)");
				if (WhaTapConf.cassandra_profile_query_enabled) {
					sb.append(" Class=").append(entityClass);
				}
				if (thr != null) {
					sb.append(" ").append(thr);
				}
				WhaTapConf.message(sb.toString(), elapsed);
			}
		}
	}

}
