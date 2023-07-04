package com.datastax.driver.core;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

@Weaving
public class SessionManager {

    public ResultSetFuture executeAsync(final Statement statement) {
        TraceContext ctx = TraceContextManager.getLocalContext();
        long stime = System.nanoTime() / 1000000;
        ResultSetFuture rs = OriginMethod.call();
        if (ctx == null) {
            return rs;
        } else {
            return new WhatapResultSetFuture(statement, stime, ctx, rs);
        }
    }

}
