package whatap.v1;

/**
 * {@link TraceCtx} 를 생성, 설정, 할당하여 와탭 모니터링 서비스에 데이터를 전송할 수 있다.
 * 
 * @author Whatap
 */
public class Trace {

	/**
	 * 현재 쓰레드에서 처리중인 트랜잭션에 대한  추적 컨텍스트{@link TraceCtx} 를 조회한다.
	 * 
	 * @return 추적 컨텍스트 TraceCtx
	 */
	public static TraceCtx context() {
		return null;
	}

	/**
	 *  입력된 아이디를 가진 트랜잭션의  추적 컨텍스{@link TraceCtx} 를 조회한다.
	 * 
	 * @return 추적 컨텍스트 TraceCtx
	 */
	public static TraceCtx context(long ctxId) {
		return null;
	}


	/**
	 * Thread 정보를 비워서 와탭 모니터링 서비스에 보낼 데이터를 수집하지 않는다.
	 */
	public static void detach() {
	}

	/**
	 * 전달받은 TraceCtx 를 통해 하나의 작업으로 연계할 수 있도록 설정한다.
	 *
	 * @param ctx 다른 thread 에서 생성한 TraceCtx
	 */
	public static void attach(TraceCtx ctx) {
	}

	/**
	 * thread 에 TraceCtx 를 설정하고 와탭 모니터링 서비스의 프로파일 정보를 수집한다.
	 *
	 * @param title 프로파일 이름
	 * @param message 프로파일 내용
	 * @param elapsed 프로파일 소요시간
	 * @param value 프로파일 부가정보
	 */
	public static void step(String title, String message, int elapsed, int value) {
	}

	/**
	 * 전달받은 TraceCtx 에 와탭 모니터링 서비스의 프로파일 정보를 추가한다.
	 *
	 * @param ctx 다른 thread 에서 생성한 TraceCtx
	 * @param title 프로파일 이름
	 * @param message 프로파일 내용
	 * @param elapsed 프로파일 소요시간
	 * @param value 프로파일 부가정보
	 */
	public static void step(TraceCtx ctx, String title, String message, int elapsed, int value) {
	}

	/**
	 * 새로운 TraceCtx 를 설정하고 추적정보를 수집한다.
	 *
	 * @param name 생성한 서비스 이름
	 * @return 새로운 TraceCtx
	 */
	public static TraceCtx start(String name) {
		return null;
	}

	/**
	 * TraceCtx 의 정보를 프로파일에 저장하고 추적정보를 비운다.
	 *
	 * @param ctx 다른 thread 에서 생성한 TraceCtx 정보
	 * @param thr TraceCtx 의 예외
	 */
	public static void end(TraceCtx ctx, Throwable thr) {
	}
}
