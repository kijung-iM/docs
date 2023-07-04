package whatap.agent.api.weaving;

import java.io.IOException;

public final class OriginMethod {

	public static final <T> T call() {
		return null;
	}
	public static final <T> T callIOException() throws IOException{
		return null;
	}
	public static final <T> T callException() throws Exception{
		return null;
	}
	public static final <T> T callThrowable() throws Throwable{
		return null;
	}
}