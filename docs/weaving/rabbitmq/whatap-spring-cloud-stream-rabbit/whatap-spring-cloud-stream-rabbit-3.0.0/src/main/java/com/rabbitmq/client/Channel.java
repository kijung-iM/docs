package com.rabbitmq.client;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
public interface Channel {
    int getChannelNumber();

    Connection getConnection();
}
