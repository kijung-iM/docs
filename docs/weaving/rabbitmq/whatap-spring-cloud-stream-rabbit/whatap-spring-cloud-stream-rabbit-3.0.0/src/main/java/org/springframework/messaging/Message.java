package org.springframework.messaging;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
public interface Message<T> {

    T getPayload();

    MessageHeaders getHeaders();
}
