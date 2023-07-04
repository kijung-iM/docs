package whatap.v1;

/**
 * 와탭 모니터링 서비스로 전송할 Task 결과
 *
 * @author Whatap
 */
public class TaskResult {

	/**
	 * TaskResult 에 등록할 tag (이름)
	 *
	 * @param key
	 * @param value
	 */
	public void tag(String key, String value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 문자열 정보 (String)
	 *
	 * @param key
	 * @param value
	 */
	public void field(String key, String value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (long)
	 *
	 * @param key
	 * @param value
	 */
	public void field(String key, long value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (float)
	 *
	 * @param key
	 * @param value
	 */
	public void field(String key, float value) {
	}

	/**
	 * TaskResult 의 tag 에 등록할 숫자 정보 (double)
	 *
	 * @param key
	 * @param value
	 */
	public void field(String key, double value) {
	}
}
