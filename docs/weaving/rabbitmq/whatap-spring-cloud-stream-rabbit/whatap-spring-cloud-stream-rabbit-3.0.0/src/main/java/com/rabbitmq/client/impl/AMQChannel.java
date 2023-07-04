package com.rabbitmq.client.impl;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
public abstract class AMQChannel {
    private AMQConnection _connection;

    public abstract AMQConnection getConnection();
}
