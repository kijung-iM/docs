package whatap.spring.boot.starter.data.mongodb.reactive;

import whatap.agent.conf.ConfTrace;
import whatap.agent.counter.meter.MeterSQL;
import whatap.agent.data.DataTextAgent;
import whatap.agent.stat.ErrorArg;
import whatap.agent.stat.StatError;
import whatap.agent.stat.StatSql;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.sql.TraceSQL;
import whatap.lang.ref.BYTE;
import whatap.lang.step.SqlStepX;
import whatap.lang.step.SqlXType;
import whatap.notice.WHATAP_ERROR;
import whatap.util.HashUtil;
import whatap.weaving.v1.WhatapConf;

public class WeaveConf {
    public static String title_mongodb_reactive = "mongodb_reactive";

    static {
        apply();
        WhatapConf.onModified(title_mongodb_reactive, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
    }

    public static void traceSql(TraceContext ctx, String dbhost, String sql, String param, int elapsed,
                                Throwable thr) {
        SqlStepX step = new SqlStepX();

        if (dbhost != null) {
            int dbc_hash = HashUtil.hash(dbhost);
            DataTextAgent.dbc(dbc_hash, dbhost);
//				DataTextAgent.ERROR.add(dbc_hash, dbhost);
            step.dbc = dbc_hash;
        }

        int sql_hash = HashUtil.hash(sql);
        DataTextAgent.SQL.add(sql_hash, sql);

        step.hash = sql_hash;
        step.xtype = SqlXType.METHOD_QUERY;

        if (ConfTrace.trace_sql_param_enabled && param != null) {
            BYTE crc = new BYTE();
            step.p1 = TraceSQL.toParamBytes(param, crc);
            step.pcrc = crc.value;
        }

        step.start_time = ctx.getElapsedTime();
        step.elapsed = elapsed;

        if (thr != null) {
            if (ConfTrace.trace_exception_stack) {
                ctx.profile(thr);
            }
            ErrorArg arg = new ErrorArg();
            arg.exception = thr;
            arg.message = thr.getMessage();
            arg.setTraceCtx(ctx);
            arg.appendSql(step.hash);
            step.error = StatError.getInstance().addError(arg);
        } else if (step.elapsed > ConfTrace.trace_error_sql_time_max) {
            ErrorArg arg = new ErrorArg();
            arg.exception = WHATAP_ERROR.slow_sql;
            arg.message = WHATAP_ERROR.slow_sql.getMessage();
            arg.setTraceCtx(ctx);
            arg.appendSql(step.hash);
            step.error = StatError.getInstance().addError(arg);
        }
        MeterSQL.getInstance().add(step.dbc, step.elapsed, step.error != 0);
        StatSql.getInstance().addSqlTime(ctx.service_hash, ctx.txid, step.dbc, step.hash, step.elapsed, step.error != 0);

        ctx.sql_count++;
        ctx.sql_time += step.elapsed;
        ctx.profile.add(step);
    }

}
