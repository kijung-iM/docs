package whatap.weaving.v1;

/**
 * {@link RemoteCallCtx} 를 생성, 설정, 할당하여 Remote Call 작업을 연계추적하여 와탭 모니터링 서비스에 전송할 데이터를 수집한다.
 * (와탭 프로파일 정보를 생성하지만 통계데이터는 생성하지 않는다.)
 *
 * @since agent v2.0_57-20210831
 */
public class RemoteCall {

	/**
	 * Remote Call 관련 프로파일을 가지고 있는 {@link RemoteCallCtx} 를 생성한다.
	 * (와탭 프로파일 정보를 생성하지만 통계데이터는 생성하지 않는다.)
	 *
	 * @param host Remote Call 호스트 정보
	 * @param port Remote Call 포트 정보
	 * @param url  Remote Call url 정보
	 * @return {@link RemoteCallCtx} 객체
	 * @since agent v2.0_57-20210831
	 */
	public static RemoteCallCtx start(String host, int port, String url) {
		return null;
	}

    /**
	 * 전달받은 {@link RemoteCallCtx} 의 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다.
	 * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * (와탭 프로파일 정보를 생성하지만 통계데이터는 생성하지 않는다.)
	 *
     * @param rcCtx RemoteCallCtx 정보
     * @param thr   Remote Call 에러정보
     * @since agent v2.0_57-20210831
     */
	public static void end(RemoteCallCtx rcCtx, Throwable thr) {
	}

    /**
	 * Whatap 설정의 원격호출추적기능 (remote_enabled) 활성화되어 있는 경우 원격 추적을 위한 값을 추가한다.
	 * Remote Call 관련 프로파일을 가지고 있는 {@link RemoteCallCtx} 를 생성한다.
	 * 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다.
	 * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * (와탭 프로파일 정보를 생성하지만 통계데이터는 생성하지 않는다.)
	 *
     * @param ctx     TraceCtx 정보
	 * @param host    Remote Call 호스트 정보
	 * @param port    Remote Call 포트 정보
	 * @param url     Remote Call url 정보
	 * @param elapsed Remote Call 응답시간
	 * @param thr     Remote Call 에러정보
     * @since agent v2.0_57-20210831
     */
	public static void trace(TraceCtx ctx, String host, int port, String url, int elapsed, Throwable thr) {

	}

    /**
	 * Whatap 설정의 원격호출추적기능 (remote_enabled) 활성화되어 있는 경우 원격 추적을 위한 값을 추가한다.
	 * Remote Call 관련 프로파일을 가지고 있는 {@link RemoteCallCtx} 를 생성한다.
	 * 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다.
	 * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * (와탭 프로파일 정보를 생성하지만 통계데이터는 생성하지 않는다.)
	 *
     * @param host    Remote Call 호스트 정보
     * @param port    Remote Call 포트 정보
     * @param url     Remote Call url 정보
     * @param elapsed Remote Call 응답시간
     * @param thr     Remote Call 에러정보
     * @since agent v2.0_57-20210831
     */
	public static void trace(String host, int port, String url, int elapsed, Throwable thr) {
	}

}
