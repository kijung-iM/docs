package org.springframework.data.r2dbc.core;

import org.reactivestreams.Publisher;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Mono;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Sql;

import java.util.function.Function;

@Weaving
abstract class R2dbcEntityTemplate {

    // count
    Mono<Long> doCount(Query query, Class<?> entityClass, SqlIdentifier tableName) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("count");
                sb.append(" entity=").append(entityClass.getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

    // exist
    Mono<Boolean> doExists(Query query, Class<?> entityClass, SqlIdentifier tableName) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("exist");
                sb.append(" entity=").append(entityClass.getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

    // find
    @SuppressWarnings("unchecked")
    <T, P extends Publisher<T>> P doSelect(Query query, Class<?> entityClass, SqlIdentifier tableName,
                                           Class<T> returnType, Function<RowsFetchSpec<T>, P> resultHandler) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("select");
                sb.append(" entity=").append(entityClass.getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

    // insert
    <T> Mono<T> doInsert(T entity, SqlIdentifier tableName) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insert");
                sb.append(" entity=").append(entity.getClass().getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

    // update
    private <T> Mono<T> doUpdate(T entity, SqlIdentifier tableName) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("update");
                sb.append(" entity=").append(entity.getClass().getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

    // delete
    Mono<Integer> doDelete(Query query, Class<?> entityClass, SqlIdentifier tableName) {
        long stime = System.nanoTime() / 1000000;
        try {
            return OriginMethod.call();
        } finally {
            long etime = System.nanoTime() / 1000000;
            int elapsed = (int) (etime - stime);
            if (elapsed >= WeaveConf.r2dbc_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("delete");
                sb.append(" entity=").append(entityClass.getName());
                sb.append(" tableName=").append(tableName);
                Sql.trace(WeaveConf.title_spring_data_r2dbc, sb.toString(), null, elapsed, null);
            }
        }
    }

}
