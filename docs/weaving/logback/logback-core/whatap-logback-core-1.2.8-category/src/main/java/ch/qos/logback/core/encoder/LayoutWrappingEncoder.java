package ch.qos.logback.core.encoder;

import ch.qos.logback.core.Layout;
import ch.qos.logback.core.LayoutBase;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class LayoutWrappingEncoder<E> {
    protected Layout<E> layout;

    public String weaveAppenderName;
    public boolean isWeaveConsoleAppender;

    public byte[] encode(E event) {
        if (this.layout instanceof LayoutBase) {
            ((LayoutBase) this.layout).weaveAppenderName = weaveAppenderName;
            ((LayoutBase) this.layout).isWeaveConsoleAppender = isWeaveConsoleAppender;
        }
        return OriginMethod.call();
    }

}
