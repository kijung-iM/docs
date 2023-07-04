package com.amazonaws.services.dynamodbv2;

import com.amazonaws.services.dynamodbv2.datamodeling.WhaTapConf;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class AmazonDynamoDBClient {

    public CreateTableResult createTable(CreateTableRequest request) {
        long stime = System.currentTimeMillis();
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.currentTimeMillis();
            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("createTable");
                if (WhaTapConf.dynamodb_show_parameter) {
                    if (request.getCustomQueryParameters() != null) sb.append(" param=").append(request.getCustomQueryParameters());
                    if (request.getAttributeDefinitions() != null) sb.append(" attr=").append(request.getAttributeDefinitions());
                    if (request.getTableName() != null) sb.append(" table=").append(request.getTableName());
                    if (request.getKeySchema() != null) sb.append(" keySchema=").append(request.getKeySchema());
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    public DeleteTableResult deleteTable(DeleteTableRequest request) {
        long stime = System.currentTimeMillis();
        Throwable thr = null;
        try {
            return OriginMethod.call();
        } catch (RuntimeException r) {
            thr = r;
            throw r;
        } finally {
            long etime = System.currentTimeMillis();
            if (thr != null || etime - stime >= WhaTapConf.dynamodb_basetime) {
                StringBuffer sb = new StringBuffer();
                sb.append("dropTable");
                if (WhaTapConf.dynamodb_show_parameter) {
                    if (request.getCustomQueryParameters() != null) sb.append(" query=").append(request.getCustomQueryParameters());
                    if (request.getTableName() != null) sb.append(" table=").append(request.getTableName());
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }

    // batchExecuteStatement, batchGetItem, batchWriteItem

    // createBackup, createGlobalTable, createTable

    // deleteBackup, deleteItem, deleteTable

    // describeBackup, describeContinuousBackups, describeContributorInsights, describeEndpoints,
    // describeExport, describeGlobalTable, describeGlobalTableSettings, describeKinesisStreamingDestination,
    // describeLimits, describeTable, describeTableReplicaAutoScaling, describeTimeToLive

    // disableKinesisStreamingDestination, enableKinesisStreamingDestination

    // executeStatement, executeTransaction, exportTableToPointInTime

    // getItem

    // listBackups, listContributorInsights, listExports, listGlobalTables, listTables, listTagsOfResource

    // putItem

    // query

    // restoreTableFromBackup, restoreTableToPointInTime

    // scan
}
