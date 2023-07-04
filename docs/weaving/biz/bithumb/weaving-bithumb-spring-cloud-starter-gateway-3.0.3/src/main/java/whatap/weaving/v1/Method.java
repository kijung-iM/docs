package whatap.weaving.v1;

/**
 * {@link MethodCtx} 를 생성, 설정, 할당하여 와탭 모니터링 서비스에 메소드 작업 데이터를 하나의 작업으로 연계하여 수집한다.
 * 
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class Method {

	/**
	 * 새로운 {@link MethodCtx} 를 생성한다.
	 * 
	 * @param name 프로파일 이름
	 * @return 추적정보를 저장할 수 있는 MethodCtx
	 * @since agent v2.0_55-20210825
	 */
	public static MethodCtx start(String name) {
		return null;
	}

	/**
	 * {@link MethodCtx} 를 전달받아 프로파일 정보를 저장하고 MethodCtx 정보 수집을 종료한다.
	 * 저장한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * 
	 * @param mctx 데이터를 저장하고 종료할 MethodCtx
	 * @param thr  에러정보
	 * @since agent v2.0_55-20210825
	 */
	public static void end(MethodCtx mctx, Throwable thr) {
	}

	/**
	 * 새로운 {@link MethodCtx} 를 생성한다.
	 * {@link MethodCtx} 를 전달받아 프로파일 정보를 저장하고 MethodCtx 정보 수집을 종료한다.
	 * 저장한 데이터를 와탭 모니터링 서비스로 전송한다.
	 *
	 * @param name    프로파일 이름
	 * @param thr     에러 정보
	 * @param elapsed 메소드 응답시간
	 * @since agent v2.0_55-20210825
	 */
	public static void trace(String name, Throwable thr, int elapsed) {
	}
}
