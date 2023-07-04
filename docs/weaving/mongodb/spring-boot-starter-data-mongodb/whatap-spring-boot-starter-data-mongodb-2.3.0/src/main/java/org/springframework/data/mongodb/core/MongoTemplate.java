package org.springframework.data.mongodb.core;

import java.util.Collection;
import java.util.List;

import com.mongodb.client.MongoDatabase;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.query.*;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import org.springframework.lang.Nullable;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.trace.TraceContext;
import whatap.agent.trace.TraceContextManager;

/**
 * spring-boot-starter-data-mongodb-2.3.0.RELEASE.jar
 * spring-data-mongodb-3.0.0.RELEASE.jar 부터 Update 타입에서 UpdateDefinition 타입으로 변경
 * => 해당 메소드 : updateFirst, updateMulti, upsert, findAndModify
 * <p>
 * spring-boot-starter-data-mongodb-2.4.0.jar
 * spring-data-mongodb-3.1.1.RELEASE.jar 부터 estimatedCount 메소드 사용
 */
@Weaving
public class MongoTemplate {
    // begin:insert
    public <T> Collection<T> insert(Collection<? extends T> batchToSave, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insert batchToSave=").append(batchToSave == null ? "null" : batchToSave.size());
                sb.append(" entityClass=").append(entityClass.getName());
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" param=").append(batchToSave);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public <T> Collection<T> insert(Collection<? extends T> batchToSave, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insert batchToSave=").append(batchToSave == null ? "null" : batchToSave.size());
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" param=").append(batchToSave);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public <T> T insert(T objectToSave) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insert objectToSave=")
                        .append(objectToSave == null ? null : objectToSave.getClass().getName());
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" param=").append(objectToSave);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public <T> T insert(T objectToSave, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insert objectToSave=")
                        .append(objectToSave == null ? null : objectToSave.getClass().getName());
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" param=").append(objectToSave);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:insert

    // begin:insertAll
    public <T> Collection<T> insertAll(Collection<? extends T> objectsToSave) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("insertAll batchToSave=").append(objectsToSave == null ? "null" : objectsToSave.size());
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" param=").append(objectsToSave);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:insertAll

    // begin:find
    public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        int result = 0;
        try {
            List<T> out = OriginMethod.call();
            result = out == null ? 0 : out.size();
            return out;
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("find entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                sb.append(" fetch=").append(result);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:find

    // begin:findAll
    public <T> List<T> findAll(Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        int result = 0;
        try {
            List<T> out = OriginMethod.call();
            result = out == null ? 0 : out.size();
            return out;
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAll entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                sb.append(" fetch=").append(result);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findAll

    // begin:findById
    @Nullable
    public <T> T findById(Object id, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findById id=").append(id);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findById

    // findOne
    @Nullable
    public <T> T findOne(Query query, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findOne entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findOne

    // begin:remove
    public DeleteResult remove(Object object, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("remove collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" object=").append(object);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public DeleteResult remove(Query query, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("remove entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:remove

    // begin:updateFirst
    public UpdateResult updateFirst(Query query, Update update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateFirst entityClass=").append(entityClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateFirst(final Query query, final Update update, final String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateFirst collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateFirst(Query query, Update update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateFirst entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateFirst(Query query, UpdateDefinition update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateFirst entityClass=").append(entityClass);
                sb.append(" UpdateDefinition=").append(update);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateFirst(Query query, UpdateDefinition update, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateFirst(Query query, UpdateDefinition update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" collectionName=").append(collectionName);
                sb.append(" entityClass=").append(entityClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:updateFirst

    // begin:updateMulti
    public UpdateResult updateMulti(Query query, Update update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateMulti entityClass=").append(entityClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateMulti(final Query query, final Update update, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateMulti collectionName=").append(collectionName);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateMulti(final Query query, final Update update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateMulti");
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append("query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateMulti(Query query, UpdateDefinition update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" entityClass=").append(entityClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append("updateMulti query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateMulti(Query query, UpdateDefinition update, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append("updateMulti query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult updateMulti(Query query, UpdateDefinition update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("updateMulti");
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:updateMulti

    // begin:upsert
    public UpdateResult upsert(Query query, Update update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert entityClass=").append(entityClass);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult upsert(Query query, Update update, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert collectionName=").append(collectionName);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult upsert(Query query, Update update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult upsert(Query query, UpdateDefinition update, Class<?> entityClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert");
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" entityClass=").append(entityClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult upsert(Query query, UpdateDefinition update, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert");
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public UpdateResult upsert(Query query, UpdateDefinition update, Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("upsert");
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:upsert

    // begin:aggregate
    protected <O> AggregationResults<O> aggregate(Aggregation aggregation, String collectionName, Class<O> outputType, @Nullable AggregationOperationContext context) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("aggregate");
                sb.append(" aggregation=").append(aggregation);
                sb.append(" collectionName=").append(collectionName);
                sb.append(" outputType=").append(outputType);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" context=").append(context);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:aggregate

    // begin:findAndModify
    @Nullable
    public <T> T findAndModify(Query query, Update update, FindAndModifyOptions options, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAndModify");
                sb.append(" Update=").append(update);
                sb.append(" options=").append(options);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    @Nullable
    public <T> T findAndModify(Query query, UpdateDefinition update, FindAndModifyOptions options, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAndModify");
                sb.append(" UpdateDefinition=").append(update);
                sb.append(" options=").append(options);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findAndModify

    // begin:findAndReplace
    public <S, T> T findAndReplace(Query query, S replacement, FindAndReplaceOptions options, Class<S> entityType, String collectionName, Class<T> resultType) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAndReplace");
                sb.append(" replacement=").append(replacement);
                sb.append(" options=").append(options);
                sb.append(" entityType=").append(entityType);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append("query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findAndReplace

    // begin:findAndRemove
    @Nullable
    public <T> T findAndRemove(Query query, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAndRemove");
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findAndRemove

    // begin:findAllAndRemove
    public <T> List<T> findAllAndRemove(Query query, Class<T> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        TraceContext ctx = TraceContextManager.getLocalContext();
        TraceContextManager.detach();
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;
            TraceContextManager.attach(ctx);
            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findAllAndRemove");
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:findAllAndRemove

    // begin:count
    public long count(Query query, @Nullable Class<?> entityClass, String collectionName) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("count");
                sb.append(" entityClass=").append(entityClass);
                sb.append(" collectionName=").append(collectionName);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:count

    // begin:distinct
    public <T> List<T> findDistinct(Query query, String field, String collectionName, Class<?> entityClass, Class<T> resultClass) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("findDistinct");
                sb.append(" field=").append(field);
                sb.append(" collectionName=").append(collectionName);
                sb.append(" entityClass=").append(entityClass);
                sb.append(" resultClass=").append(resultClass);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:distinct

    // begin:mapReduce
    public <T> List<T> mapReduce(Query query, Class<?> domainType, String inputCollectionName, String mapFunction, String reduceFunction, @Nullable MapReduceOptions mapReduceOptions, Class<T> resultType) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("mapReduce");
                sb.append(" domainType=").append(domainType);
                sb.append(" inputCollectionName=").append(inputCollectionName);
                sb.append(" mapFunction=").append(mapFunction);
                sb.append(" reduceFunction=").append(reduceFunction);
                sb.append(" mapReduceOptions=").append(mapReduceOptions);
                sb.append(" resultType=").append(resultType);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" query=").append(query);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:mapReduce

    // begin:geoNear
    public <T> GeoResults<T> geoNear(NearQuery near, Class<?> domainType, String collectionName, Class<T> returnType) {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("geoNear");
                sb.append(" domainType=").append(domainType);
                sb.append(" collectionName=").append(collectionName);
                sb.append(" returnType=").append(returnType);
                if (WhaTapConf.mongodb_show_parameter) {
                    sb.append(" NearQuery=").append(near);
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:geoNear

    // begin:getDb
    public MongoDatabase getDb() {
        long stime = System.nanoTime() / 1000000;
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.nanoTime() / 1000000;

            if (thr != null || etime - stime >= WhaTapConf.mongodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("getDb");
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
    // end:getDb

}
