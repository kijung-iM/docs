package org.apache.logging.log4j.core.layout;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogSink;

import java.util.ArrayList;
import java.util.List;

// PatternLayout 변환 위해 PatternLayout 에 Layout 을 implement 하는 작업 진행
@Weaving
abstract public class PatternLayout implements Layout {

    public String weaveAppenderName;

    /**
     * Creates a text representation of the specified log event
     * and writes it into the specified StringBuilder.
     * <p>
     * Implementations are free to return a new StringBuilder if they can
     * detect in advance that the specified StringBuilder is too small.
     */
    private StringBuilder toText(final AbstractStringLayout.Serializer2 serializer, final LogEvent event,
                                 final StringBuilder destination) {
        StringBuilder originResult = OriginMethod.call();
        try {
            if (weaveAppenderName != null || weaveAppenderName.length() > 0) {
                List<String[]> levelTag = new ArrayList<>(1);
                levelTag.add(new String[]{"level", event.getLevel().name()});
                LogSink.trace(weaveAppenderName, levelTag, originResult.toString());
            } else {
                LogSink.trace("AppLog4j", originResult.toString());
            }
        } catch (Exception e) {
        }
        return originResult;
    }

}
