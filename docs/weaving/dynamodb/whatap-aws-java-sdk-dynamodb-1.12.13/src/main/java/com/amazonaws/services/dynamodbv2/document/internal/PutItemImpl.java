package com.amazonaws.services.dynamodbv2.document.internal;

import com.amazonaws.services.dynamodbv2.datamodeling.WhaTapConf;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class PutItemImpl {

    private PutItemOutcome doPutItem(PutItemSpec spec) {
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
                sb.append("putItem");
                if (WhaTapConf.dynamodb_show_parameter) {
                    sb.append(" item=").append(spec.getItem());
                }
                if (thr != null) {
                    sb.append(" ").append(thr);
                }
                WhaTapConf.message(sb.toString(), etime - stime);
            }
        }
    }
}
