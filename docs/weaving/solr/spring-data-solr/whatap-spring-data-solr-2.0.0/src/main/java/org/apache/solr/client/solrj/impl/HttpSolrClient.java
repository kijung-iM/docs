package org.apache.solr.client.solrj.impl;

import org.apache.solr.client.solrj.ResponseParser;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.*;

import java.io.IOException;

import static whatap.spring.data.solr.WeaveConf.*;

@Weaving
public class HttpSolrClient {

    protected volatile String baseUrl;
    private static TraceCtx weaveCtx;

    public NamedList<Object> request(final SolrRequest request, final ResponseParser processor, String collection)
            throws SolrServerException, IOException {

        TraceCtx ctx = weaveCtx;
        long stime = System.currentTimeMillis();

        try {
            return OriginMethod.call();
        } finally {
            if (ctx != null) {
                long etime = System.currentTimeMillis();
                int elapsed = (int) (etime - stime);

                if (elapsed > solr_basetime) {
                    if (solr_profile_enabled) {
                        StringBuilder sb = new StringBuilder();

                        sb.append("baseURL=").append(baseUrl);
                        sb.append(" collection=").append(collection);
                        sb.append(" path=").append(request.getPath());
                        SolrParams solrParams = request.getParams();
                        if (solrParams != null) {
                            String strParams = solrParams.toString();
                            int len = Math.min(solr_params_limit, strParams.length());
                            strParams = strParams.substring(0, len);
                            sb.append(" ").append(strParams);
                        }
                        Trace.step(ctx, title_solr_solrj, sb.toString(), elapsed, 0);
                    }
                }

                weaveCtx = null;
                Trace.end(ctx, null);
            }

            if (ctx == null) {
                ctx = Trace.context();
                long etime = System.currentTimeMillis();
                int elapsed = (int) (etime - stime);

                if (elapsed > solr_basetime) {
                    if (solr_profile_enabled) {
                        StringBuilder sb = new StringBuilder();

                        sb.append("baseURL=").append(baseUrl);
                        sb.append(" collection=").append(collection);
                        sb.append(" path=").append(request.getPath());
                        SolrParams solrParams = request.getParams();
                        if (solrParams != null) {
                            String strParams = solrParams.toString();
                            int len = Math.min(solr_params_limit, strParams.length());
                            strParams = strParams.substring(0, len);
                            sb.append(" ").append(strParams);
                        }
                        Trace.step(ctx, title_solr_solrj, sb.toString(), elapsed, 0);
                    }
                }
                weaveCtx = Trace.context();
            }
        }
    }

}