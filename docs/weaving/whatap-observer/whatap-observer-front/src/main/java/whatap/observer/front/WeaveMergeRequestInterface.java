package whatap.observer.front;

import io.whatap.client.exec.MergeRequest;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.Branch;
import whatap.weaving.v1.BranchCtx;
import whatap.weaving.v1.TraceCtx;

@Weaving(match = "interface", name = "io.whatap.client.exec.MergeRequest", prefix = "io.whatap.server.front.web.transfer.remote")
public class WeaveMergeRequestInterface implements MergeRequest {

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
