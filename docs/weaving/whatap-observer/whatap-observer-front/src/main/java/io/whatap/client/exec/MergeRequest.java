package io.whatap.client.exec;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
public interface MergeRequest {
    String request();
}
