package com.amazonaws.services.dynamodbv2.datamodeling;

import whatap.agent.api.weaving.Weaving;

@Weaving
public class DynamoDBMapper {

//    public <T> void save(T object, DynamoDBSaveExpression saveExpression, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("save");
//                sb.append(" class=").append(object.getClass().getName());
//                if (saveExpression != null) {
//                    if (WhaTapConf.dynamodb_show_parameter) {
//                        sb.append(" expr=").append(saveExpression.getExpected());
//                    }
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    public <T> PaginatedScanList<T> scan(Class<T> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            return OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("scan");
//                sb.append(" class=").append(clazz.getName());
//                if (scanExpression != null) {
//                    if (WhaTapConf.dynamodb_show_parameter) {
//                        sb.append(" expr=").append(scanExpression);
//                        sb.append(" filter=").append(scanExpression.getFilterExpression());
//                    }
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    public <T> T load(Class<T> clazz, Object hashKey, Object rangeKey, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            return OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("load");
//                sb.append(" class=").append(clazz.getName());
//                if (WhaTapConf.dynamodb_show_parameter) {
//                    if (hashKey != null) sb.append(" hashKey=").append(hashKey.getClass().getName());
//                    if (rangeKey != null) sb.append(" rangeKey=").append(rangeKey.getClass().getName());
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    public <T> T load(T keyObject, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            return OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("load");
//                sb.append(" class=").append(keyObject.getClass().getName());
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    public <T> void delete(T object, DynamoDBDeleteExpression deleteExpression, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("delete");
//                sb.append(" class=").append(object.getClass().getName());
//                if (deleteExpression != null) {
//                    if (WhaTapConf.dynamodb_show_parameter) {
//                        sb.append(" expr=").append(deleteExpression.getExpected());
//                    }
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    // transactionWrite, transactionLoad
//
//    // batchDelete, batchSave, batchWrite, batchLoad,
//    public List<FailedBatch> batchWrite(Iterable<? extends Object> objectsToWrite, Iterable<? extends Object> objectsToDelete, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            return OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("batch");
//                if (WhaTapConf.dynamodb_show_parameter) {
//                    if (objectsToWrite != null) {
//                        for (Object ob : objectsToWrite) {
//                            sb.append(" write=").append(ob.getClass().getName());
//                        }
//                    }
//                    if (objectsToDelete != null) {
//                        for (Object ob : objectsToDelete) {
//                            sb.append(" delete=").append(ob.getClass().getName());
//                        }
//                    }
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }
//
//    public Map<String, List<Object>> batchLoad(Iterable<? extends Object> itemsToGet, DynamoDBMapperConfig config) {
//        long stime = System.currentTimeMillis();
//        Throwable thr = null;
//        try {
//            return OriginMethod.call();
//        } catch (RuntimeException r) {
//            thr = r;
//            throw r;
//        } finally {
//            long etime = System.currentTimeMillis();
//            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
//                StringBuffer sb = new StringBuffer();
//                sb.append("batch");
//                if (WhaTapConf.dynamodb_show_parameter) {
//                    if (itemsToGet != null) {
//                        for (Object ob : itemsToGet) {
//                            sb.append(" load=").append(ob.getClass().getName());
//                        }
//                    }
//                }
//                if (thr != null) {
//                    sb.append(" ").append(thr);
//                }
//                WhaTapConf.message(sb.toString(), etime - stime);
//            }
//        }
//    }

    // parallelScan, scanPage

    // query, queryPage

    // count

    // getS3ClientCache, createS3Link

    // generateCreateTableRequest, generateDeleteTableRequest

}
