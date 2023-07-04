package io.whatap.client.exec;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.observer.front.WeaveConf;
import whatap.weaving.v1.*;

@Weaving
public class MergeRequestExecutor {

    public void run(final MergeRequest mergeRequest) {
        TraceCtx ctx = Trace.context();
        if (ctx != null) {
            if (WeaveConf.map.size() > 10000) {
                Log.println("[WeaveConf] " + this.getClass().getName() + " TraceCtx Map size over 10000, Map.size: " + WeaveConf.map.size());
                WeaveConf.map.clear();
            }
            WeaveConf.map.put(System.identityHashCode(mergeRequest), ctx);
        }
        OriginMethod.call();
    }
}
