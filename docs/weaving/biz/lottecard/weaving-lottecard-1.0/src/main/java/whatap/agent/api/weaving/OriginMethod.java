package whatap.agent.api.weaving;

import com.cspi.ems.EaiException;

import java.io.IOException;

@SkipLoad
public final class OriginMethod {

    public OriginMethod() {
    }

    public static final <T> T call() {
        return null;
    }

    public static final <T> T callIOException() throws IOException {
        return null;
    }

    public static final <T> T callException() throws Exception {
        return null;
    }

    public static final <T> T callEaiException() throws EaiException {
        return null;
    }

    public static final <T> T callThrowable() throws Throwable {
        return null;
    }
}