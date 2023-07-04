package org.apache.solr.handler;

import org.apache.solr.core.SolrCore;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Trace;
import whatap.weaving.v1.TraceCtx;

import java.util.Map;

import static whatap.spring.data.solr.WeaveConf.*;


@Weaving
public class RequestHandlerBase {

    public void handleRequest(SolrQueryRequest req, SolrQueryResponse rsp) {
        TraceCtx ctx = Trace.context();
        long stime = System.currentTimeMillis();

        try {
            OriginMethod.call();
        } finally {
            long etime = System.currentTimeMillis();
            int elapsed = (int) (etime - stime);

            if (elapsed > solr_basetime) {
                if (solr_profile_enabled) {
                    StringBuilder sb = new StringBuilder();

                    if (req.getSearcher() != null) {
                        SolrCore solrCore = req.getSearcher().getCore();
                        if (solrCore != null) sb.append("core=").append(solrCore.getName()).append(" ");
                    }

                    if (req.getContext() != null) {
                        Map<Object, Object> reqContext = req.getContext();
                        Object webapp = reqContext.get("webapp");
                        if (webapp != null) sb.append("webapp=").append(webapp).append(" ");
                    }

                    String reqPath = req.getPath();
                    if (reqPath != null && reqPath.length() > 0) sb.append("path=").append(reqPath).append(" ");

                    String reqParams = req.getParamString();
                    if (reqParams != null && reqParams.length() > 0) {
                        int len = Math.min(solr_params_limit, reqParams.length());
                        reqParams = reqParams.substring(0, len);
                        sb.append("params=").append(reqParams).append(" ");
                    }

                    Trace.step(ctx, title_solr_core, sb.toString(), elapsed, 0);
                }
            }
            Trace.end(ctx, null);
        }
    }
}
