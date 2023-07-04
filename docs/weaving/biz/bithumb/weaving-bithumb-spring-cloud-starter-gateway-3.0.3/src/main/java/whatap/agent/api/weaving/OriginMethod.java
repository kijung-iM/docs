package whatap.agent.api.weaving;

import java.io.IOException;

/**
 * @since agent v2.0_55-20210825
 */
public final class OriginMethod {

	/**
	 * @since agent v2.0_55-20210825
	 */
	public static final <T> T call() {
		return null;
	}

	/**
	 * @since agent v2.0_55-20210825
	 */
	public static final <T> T callIOException() throws IOException{
		return null;
	}

	/**
	 * @since agent v2.0_55-20210825
	 */
	public static final <T> T callException() throws Exception{
		return null;
	}

	/**
	 * @since agent v2.0_55-20210825
	 */
	public static final <T> T callThrowable() throws Throwable{
		return null;
	}
}