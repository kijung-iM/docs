package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogSink;

import java.util.ArrayList;
import java.util.List;

@Weaving
public class PatternLayout {
    /**
     Produces a formatted string as specified by the conversion pattern.
     */
    public String format(LoggingEvent event) {
        String logResult = OriginMethod.call();
        if (event.weaveEvented == false) {
            event.weaveEvented = true;
            if (event.getLevel() != null) {
                List<String[]> levelTag = new ArrayList(1);
                levelTag.add(new String[]{"level", event.getLevel().toString()});
                LogSink.trace("AppLog4j", levelTag, logResult);
            } else {
                LogSink.trace("AppLog4j", logResult);
            }
        }
        return logResult;
    }
}
