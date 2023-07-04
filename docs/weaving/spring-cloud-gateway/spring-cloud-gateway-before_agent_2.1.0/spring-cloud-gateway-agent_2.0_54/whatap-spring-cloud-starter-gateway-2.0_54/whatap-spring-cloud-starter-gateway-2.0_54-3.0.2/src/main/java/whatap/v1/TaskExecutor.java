package whatap.v1;

/**
 * 새로운 Task 내역을 생성한다.
 *
 * @author Whatap
 */
public class TaskExecutor {

	/**
	 * 새로운 Task 내역을 생성한다.
	 *
	 * @param name Task 이름
	 * @param interval 동작 주기
	 * @param task Task 클래스
	 */
	public static void regist(String name, long interval, ITask task) {
	}

	/**
	 * 새로운 Task 내역을 생성한다.
	 *
	 * @param name Task 이름
	 * @param interval 동작 주기
	 * @param exactTime 정각 동작여부
	 * @param task Task 클래스
	 */
	public static void regist(String name, long interval, boolean exactTime, ITask task) {
	}
}
