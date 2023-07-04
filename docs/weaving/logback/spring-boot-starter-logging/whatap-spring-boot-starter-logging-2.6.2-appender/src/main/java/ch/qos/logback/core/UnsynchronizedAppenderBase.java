package ch.qos.logback.core;

import whatap.agent.api.weaving.Weaving;

@Weaving
public class UnsynchronizedAppenderBase<E> {
    protected String name;
}
