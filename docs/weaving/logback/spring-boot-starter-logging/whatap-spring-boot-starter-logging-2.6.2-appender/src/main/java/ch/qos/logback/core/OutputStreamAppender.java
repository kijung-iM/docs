package ch.qos.logback.core;

import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

import java.io.OutputStream;

@Weaving
public class OutputStreamAppender<E> extends UnsynchronizedAppenderBase<E> {
    protected Encoder<E> encoder;
    protected void subAppend(E event) {
        if (encoder instanceof LayoutWrappingEncoder) {
            ((LayoutWrappingEncoder) (encoder)).weaveAppenderName = name;

            if (this instanceof ConsoleAppender) {
                ((LayoutWrappingEncoder) (encoder)).isWeaveConsoleAppender = true;
            }
        }

        OriginMethod.call();
    }
}
