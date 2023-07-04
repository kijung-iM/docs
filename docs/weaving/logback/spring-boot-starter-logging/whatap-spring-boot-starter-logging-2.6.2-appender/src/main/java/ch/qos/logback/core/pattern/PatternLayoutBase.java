package ch.qos.logback.core.pattern;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.LayoutBase;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.HashMap;
import java.util.Map;

@Weaving
public abstract class PatternLayoutBase<E> extends LayoutBase<E> {

    protected String writeLoopOnConverters(E event) {
        String originResult = OriginMethod.call();

        if (isWeaveConsoleAppender == false) {
            LoggingEvent loggingEvent;
            if (event != null) {
                if (event instanceof LoggingEvent) {
                    loggingEvent = (LoggingEvent) event;

                    LogBox logBox = new LogBox();
                    Map<String, String> tags = new HashMap();
                    Map<String, String> fields = new HashMap();
                    logBox.time = loggingEvent.getTimeStamp();
                    if (loggingEvent.getLevel() != null) tags.put("level", loggingEvent.getLevel().levelStr);
                    if (loggingEvent.getThreadName() != null) fields.put("@threadName", loggingEvent.getThreadName());
                    if (loggingEvent.getLoggerName() != null) fields.put("@location", loggingEvent.getLoggerName());
                    if (loggingEvent.getThrowableProxy() != null) {
                        tags.put("exception", loggingEvent.getThrowableProxy().getClassName());
                        logBox.content = originResult;
                    } else {
                        String formattedMessage = loggingEvent.getFormattedMessage();
                        if (formattedMessage != null) logBox.content = formattedMessage;
                    }

                    if (weaveAppenderName != null || weaveAppenderName.length() > 0) {
                        tags.put("appender", weaveAppenderName);
                    }

                    logBox.category = "AppLog";
                    logBox.tags = tags;
                    logBox.fields = fields;
                    LogSink.trace(logBox);
                }
            }
        }

        return originResult;
    }
}
