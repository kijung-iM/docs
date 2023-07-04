package io.whatap.server.gateway.web.util;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.observer.front.WeaveConf;
import whatap.weaving.v1.Branch;
import whatap.weaving.v1.BranchCtx;
import whatap.weaving.v1.TraceCtx;

@Weaving
public class AbstractMergeRequest {

    public String request() {
        TraceCtx ctx = WeaveConf.map.remove(System.identityHashCode(this));

        BranchCtx bctx = Branch.start(ctx);
        try {
            return OriginMethod.call();
        } finally {
            Branch.end(bctx);
        }
    }
}
