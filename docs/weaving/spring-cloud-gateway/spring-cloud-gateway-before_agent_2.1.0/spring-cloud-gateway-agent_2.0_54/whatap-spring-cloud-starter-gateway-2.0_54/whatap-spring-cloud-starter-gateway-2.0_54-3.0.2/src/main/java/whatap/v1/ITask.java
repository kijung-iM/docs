package whatap.v1;

/**
 * ITask 는 Task 의 작업내역 결과인 {@link TaskResult} 를 와탭 모니터링 서비스로 전송하는 인터페이스 클래스이다.
 *
 * @author Whatap
 */
public interface ITask {

	/**
	 * {@link TaskResult} 를 와탭 모니터링 서비스로 전송한다.
	 *
	 * @param result Task 결과
	 */
	public void process(TaskResult result);
}
