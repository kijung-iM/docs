package org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.impl.ExtendedStackTraceElement;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.SkipLoad;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.HashMap;
import java.util.Map;

import static whatap.spring.boot.starter.log4j2.WeaveConf.log4j2_stack_depth;

@Weaving
public class LoggerConfig {

    private void processLogEvent(final LogEvent event, final LoggerConfigPredicate predicate) {
        OriginMethod.call();

        if (event != null) {
            LogBox logBox = new LogBox();
            Map<String, String> tags = new HashMap();
            Map<String, String> fields = new HashMap();
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
            logBox.category = "AppLog";
            logBox.tags = tags;
            logBox.fields = fields;
            LogSink.trace(logBox);
        }
    }

    @SkipLoad
    protected static enum LoggerConfigPredicate {
    }

}
