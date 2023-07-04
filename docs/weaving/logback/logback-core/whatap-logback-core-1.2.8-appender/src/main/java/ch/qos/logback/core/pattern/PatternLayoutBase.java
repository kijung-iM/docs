package ch.qos.logback.core.pattern;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.LayoutBase;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.HashMap;
import java.util.Map;

import static whatap.logback.core.WeaveConf.*;

@Weaving
public abstract class PatternLayoutBase<E> extends LayoutBase<E> {

    protected String writeLoopOnConverters(E event) {
        String originResult = OriginMethod.call();

//        if (hasLogbackList) {
//            if (weaveAppenderName != null && weaveAppenderName.length() > 0) {
//                boolean hasAppender = logbackAppenderList.contains(weaveAppenderName);
//                if (hasAppender) {
//                    for (String str : logbackAppenderList) {
//                        if (weaveAppenderName.equals(str)) {
//                            weaveAppender(event, weaveAppenderName);
//                        }
//                    }
//                }
//            }
//        }
        if (logback_save_console == false && isWeaveConsoleAppender) return originResult;

        if (weaveAppenderName != null && weaveAppenderName.length() > 0) {
            weaveAppender(event, weaveAppenderName);
        }
        return originResult;
    }

    public void weaveAppender(E event, String appenderName) {
        LoggingEvent loggingEvent;
        if (event != null) {
            if (event instanceof LoggingEvent) {
                loggingEvent = (LoggingEvent) event;

                LogBox logBox = new LogBox();
                Map<String, String> tags = new HashMap();
                Map<String, String> fields = new HashMap();
                logBox.time = loggingEvent.getTimeStamp();
                if (loggingEvent.getLevel() != null)
                    tags.put("level", loggingEvent.getLevel().levelStr);
                if (loggingEvent.getThreadName() != null)
                    fields.put("threadName", loggingEvent.getThreadName());
                if (loggingEvent.getLoggerName() != null)
                    fields.put("loggerName", loggingEvent.getLoggerName());

                IThrowableProxy iThrowableProxy = loggingEvent.getThrowableProxy();
                if (iThrowableProxy != null) {
                    tags.put("exception", iThrowableProxy.getClassName());

                    StringBuilder sb = new StringBuilder();
                    sb.append(iThrowableProxy.getClassName()).append(": ").append(iThrowableProxy.getMessage()).append("\n");
                    StackTraceElementProxy[] stackTraceElementProxies = iThrowableProxy.getStackTraceElementProxyArray();

                    if (logback_stack_depth > 0) {
                        int len = Math.min(logback_stack_depth, stackTraceElementProxies.length);
                        for (int i = 0; i < len; i++) {
                            sb.append("\t").append(stackTraceElementProxies[i]);
                            sb.append("\n");
                        }
                    }
                    logBox.content = sb.toString();
                } else {
                    String formattedMessage = loggingEvent.getFormattedMessage();
                    if (formattedMessage != null) logBox.content = formattedMessage;
                }

                if (hasLogbackCategoryList) {
                    for (String appName : logbackCategoryList) {
                        if (weaveAppenderName.equals(appName)) {
                            logBox.category = weaveAppenderName;
                        }
                    }
                } else {
                    logBox.category = logback_main_category;
                    tags.put("appender", weaveAppenderName);
                }
                logBox.tags = tags;
                logBox.fields = fields;
                LogSink.trace(logBox);
            }
        }
    }
}
