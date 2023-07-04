package whatap.weaving.v1;

/**
 * 와탭 모니터링 서비스로 전송할 Task 결과
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class TaskResult {

	/**
	 * TaskResult 에 등록할 tag (이름)
	 *
	 * @since agent v2.0_55-20210825
	 */
	public void tag(String key, String value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 문자열 정보 (String)
	 *
	 * @since agent v2.0_55-20210825
	 */
	public void field(String key, String value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (long)
	 *
	 * @since agent v2.0_55-20210825
	 */
	public void field(String key, long value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (float)
	 *
	 * @since agent v2.0_55-20210825
	 */
	public void field(String key, float value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (double)
	 *
	 * @since agent v2.0_55-20210825
	 */
	public void field(String key, double value) {
	}
}
