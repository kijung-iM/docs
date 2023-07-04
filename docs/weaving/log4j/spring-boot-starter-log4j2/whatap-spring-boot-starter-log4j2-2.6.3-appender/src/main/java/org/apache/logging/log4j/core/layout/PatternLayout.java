package org.apache.logging.log4j.core.layout;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.impl.ExtendedStackTraceElement;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.*;

import java.util.HashMap;
import java.util.Map;

import static whatap.spring.boot.starter.log4j2.WeaveConf.log4j2_stack_depth;

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
            if (event != null) {
                LogBox logBox = new LogBox();
                Map<String, String> tags = new HashMap<>();
                Map<String, String> fields = new HashMap<>();
                logBox.time = event.getTimeMillis();
                if (event.getLevel() != null) tags.put("level", event.getLevel().name());
                if (event.getThreadName() != null) fields.put("@threadName", event.getThreadName());
                if (event.getLoggerName() != null) fields.put("@location", event.getLoggerName());

                ThrowableProxy throwableProxy = event.getThrownProxy();
                if (throwableProxy != null) {

                    tags.put("exception", throwableProxy.getName());

                    StringBuilder sb = new StringBuilder();
                    ExtendedStackTraceElement[] extendedStackTraceElements = throwableProxy.getExtendedStackTrace();
                    if (log4j2_stack_depth > 0) {
                        int len = Math.min(log4j2_stack_depth, extendedStackTraceElements.length);
                        sb.append(throwableProxy.getName()).append(": ").append(throwableProxy.getMessage()).append("\n");
                        for (int i = 0; i < len; i++) {
                            sb.append("\t").append(extendedStackTraceElements[i]);
                            sb.append("\n");
                        }
                    }
                    logBox.content = sb.toString();
                } else {
                    if (event.getMessage() != null) logBox.content = event.getMessage().getFormattedMessage();
                }

                if (weaveAppenderName != null || weaveAppenderName.length() > 0) {
                    tags.put("appender", weaveAppenderName);
                }

                logBox.category = "AppLog";
                logBox.tags = tags;
                logBox.fields = fields;
                LogSink.trace(logBox);
            }
        } catch (Exception e) {
        }
        return originResult;
    }

}
