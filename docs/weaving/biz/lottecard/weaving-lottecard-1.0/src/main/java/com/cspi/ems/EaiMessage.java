package com.cspi.ems;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
public interface EaiMessage {
    byte[] getData();
}
