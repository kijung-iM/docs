package ch.qos.logback.core;

import whatap.agent.api.weaving.Weaving;

@Weaving
public class LayoutBase<E> {
    public String weaveAppenderName;
    public boolean isWeaveConsoleAppender;
}
