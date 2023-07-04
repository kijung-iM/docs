package org.apache.logging.log4j.core.appender;

import java.io.Serializable;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.layout.PatternLayout;
import whatap.agent.api.weaving.Weaving;

@Weaving
public abstract class AbstractOutputStreamAppender<M extends OutputStreamManager> {

    /**
     * Instantiates a WriterAppender and set the output destination to a new {@link java.io.OutputStreamWriter}
     * initialized with <code>os</code> as its {@link java.io.OutputStream}.
     *
     * @param name       The name of the Appender.
     * @param layout     The layout to format the message.
     * @param properties optional properties
     * @param manager    The OutputStreamManager.
     */
    protected AbstractOutputStreamAppender(final String name, final Layout<? extends Serializable> layout,
                                           final Filter filter, final boolean ignoreExceptions, final boolean immediateFlush,
                                           final Property[] properties, final M manager) {

        // PatternLayout 변환 위해 PatternLayout 에 Layout 을 implement 하는 작업 진행
        if (layout instanceof PatternLayout) {
            ((PatternLayout) layout).weaveAppenderName = name;
        }

    }

}
