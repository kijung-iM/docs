package whatap.weaving.v1;

/**
 * 와탭 로그 모니터링 서비스에 전송할 데이터를 수집한다.
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class Log {

	/**
	 * 와탭 로그 모니터링 서비스에 로그를 쌓는다.
	 *
	 * @param id 로그 아이디
	 * @param message 로그 내용
	 * @since agent v2.0_55-20210825
	 */
	public static void println(String id, String message) {
	}

	/**
	 * 와탭 로그 모니터링 서비스에 로그를 쌓는다.
	 *
	 * @param message 로그 내용
	 * @since agent v2.0_55-20210825
	 */
	public static void println(String message) {
	}

	/**
	 * 와탭 모니터링 서비스에 로그를 쌓는다. (노란색)
	 *
	 * @param message 로그 내용
	 * @since agent v2.0_55-20210825
	 */
	public static void yellow(String message) {
	}

	/**
	 * 와탭 모니터링 서비스에 로그를 쌓는다. (빨간색)
	 *
	 * @param message 로그 내용
	 * @since agent v2.0_55-20210825
	 */
	public static void red(String message) {
	}
}
