package ch.qos.logback.classic;

import ch.qos.logback.classic.spi.*;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.HashMap;
import java.util.Map;

import static whatap.logback.core.WeaveConf.logback_stack_depth;

@Weaving
public class Logger {
    public void callAppenders(ILoggingEvent event) {
        OriginMethod.call();

        if (event != null) {
            LogBox logBox = new LogBox();
            Map<String, String> tags = new HashMap();
            Map<String, String> fields = new HashMap();
            logBox.time = event.getTimeStamp();
            if (event.getLevel() != null) tags.put("level", event.getLevel().levelStr);
            if (event.getThreadName() != null) fields.put("threadName", event.getThreadName());
            if (event.getLoggerName() != null) fields.put("loggerName", event.getLoggerName());

            IThrowableProxy iThrowableProxy = event.getThrowableProxy();
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
                String formattedMessage = event.getFormattedMessage();
                if (formattedMessage != null) logBox.content = formattedMessage;
            }
            logBox.category = "AppLog";
            logBox.tags = tags;
            logBox.fields = fields;
            LogSink.trace(logBox);
        }
    }

}
