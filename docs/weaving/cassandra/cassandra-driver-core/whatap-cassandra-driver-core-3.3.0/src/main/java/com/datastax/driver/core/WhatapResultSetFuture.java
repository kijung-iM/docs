package com.datastax.driver.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

public class WhatapResultSetFuture implements ResultSetFuture {
	final ResultSetFuture rs;
	private String query;
	private long stime;
	private TraceContext ctx;
	private Statement statement;

	public WhatapResultSetFuture(String query, long stime, TraceContext ctx, ResultSetFuture rs) {
		this.query = query;
		this.stime = stime;
		this.ctx = ctx;
		this.rs = rs;
	}

	public WhatapResultSetFuture(Statement statement, long stime, TraceContext ctx, ResultSetFuture rs) {
		this.statement = statement;
		this.stime = stime;
		this.ctx = ctx;
		this.rs = rs;
	}

	@Override
	public void addListener(Runnable listener, Executor executor) {
		rs.addListener(listener, executor);
	}

	@Override
	public boolean isCancelled() {
		return rs.isCancelled();
	}

	@Override
	public boolean isDone() {
		return rs.isDone();
	}

	@Override
	public ResultSet get() throws InterruptedException, ExecutionException {
		Throwable thr = null;
		try {
			return rs.get();
		} catch (InterruptedException r) {
			thr = r;
			throw r;
		} catch (ExecutionException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				try {
					TraceContextManager.attach(ctx);
					StringBuffer sb = new StringBuffer();
					sb.append("get");
					if (WhaTapConf.cassandra_show_query) {
						if (query != null) {
							sb.append(" query=").append(query);
						} else {
							if (statement instanceof BoundStatement) {
								BoundStatement bs = (BoundStatement) statement;
								sb.append(" stmt=").append(bs.preparedStatement().getQueryString());
							} else {
								sb.append(" stmt=").append(statement);
							}
						}
					}
					if (thr != null) {
						sb.append(" ").append(thr);
					}
					WhaTapConf.message(sb.toString(), elapsed);
				} catch (Throwable t) {

				}
			}
		}
	}

	@Override
	public ResultSet get(long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		Throwable thr = null;
		try {
			return rs.get(timeout, unit);
		} catch (InterruptedException r) {
			thr = r;
			throw r;
		} catch (ExecutionException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				try {
					TraceContextManager.attach(ctx);
					StringBuffer sb = new StringBuffer();
					sb.append("get");
					if (WhaTapConf.cassandra_show_query) {
						if (query != null) {
							sb.append(" query=").append(query);
						} else {
							if (statement instanceof BoundStatement) {
								BoundStatement bs = (BoundStatement) statement;
								sb.append(" stmt=").append(bs.preparedStatement().getQueryString());
							} else {
								sb.append(" stmt=").append(statement);
							}
						}
					}
					if (thr != null) {
						sb.append(" ").append(thr);
					}
					WhaTapConf.message(sb.toString(), elapsed);
				} catch (Throwable t) {

				}
			}
		}
	}

	@Override
	public ResultSet getUninterruptibly() {
		try {
			return rs.getUninterruptibly();
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (etime - stime >= WhaTapConf.cassandra_basetime) {
				try {
					TraceContextManager.attach(ctx);
					StringBuffer sb = new StringBuffer();
					sb.append("get-uninter");
					if (WhaTapConf.cassandra_show_query) {
						if (query != null) {
							sb.append(" query=").append(query);
						} else {
							if (statement instanceof BoundStatement) {
								BoundStatement bs = (BoundStatement) statement;
								sb.append(" stmt=").append(bs.preparedStatement().getQueryString());
							} else {
								sb.append(" stmt=").append(statement);
							}
						}
					}
					WhaTapConf.message(sb.toString(), elapsed);
				} catch (Throwable t) {

				}
			}
		}
	}

	@Override
	public ResultSet getUninterruptibly(long timeout, TimeUnit unit) throws TimeoutException {
		Throwable thr = null;
		try {
			return rs.getUninterruptibly(timeout, unit);
		} catch (TimeoutException r) {
			thr = r;
			throw r;
		} finally {
			long etime = System.nanoTime() / 1000000;
			long elapsed = etime - stime;
			if (thr != null || elapsed >= WhaTapConf.cassandra_basetime) {
				try {
					TraceContextManager.attach(ctx);
					StringBuffer sb = new StringBuffer();
					sb.append("get-uninter");
					if (WhaTapConf.cassandra_show_query) {
						if (query != null) {
							sb.append(" query=").append(query);
						} else {
							if (statement instanceof BoundStatement) {
								BoundStatement bs = (BoundStatement) statement;
								sb.append(" stmt=").append(bs.preparedStatement().getQueryString());
							} else {
								sb.append(" stmt=").append(statement);
							}
						}
					}
					if (thr != null) {
						sb.append(" ").append(thr);
					}
					WhaTapConf.message(sb.toString(), elapsed);
				} catch (Throwable t) {

				}
			}
		}
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return rs.cancel(mayInterruptIfRunning);
	}

}
