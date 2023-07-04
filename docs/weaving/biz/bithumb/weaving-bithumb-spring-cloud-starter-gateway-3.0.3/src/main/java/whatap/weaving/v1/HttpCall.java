package whatap.weaving.v1;

import java.util.Map;

/**
 * {@link HttpCallCtx} 를 생성, 설정, 할당하여 HttpCall 작업을 연계추적하여 와탭 모니터링 서비스에 전송할 데이터를 수집한다.
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class HttpCall {

    /**
     * 와탭 설정의 멀티추적기능 (mtrace_enabled) 활성화되어 있는 경우 멀티 추적을 위한 값을 추가한다.
     *
     * @return 멀티추적 키
     * @since agent v2.0_55-20210825
     */
    public static Map<String, String> mtrace() {
        return null;
    }

    /**
     * 와탭 설정의 멀티추적기능(mtace_enabled) 활성화되어 있는 경우 멀티 추적을 위한 값을 추가한다.
     *
     * @param ctx    다른 쓰레드에서 생성한 TraceCtx
     * @param trInfo 멀티추적 키
     * @since agent v2.0_55-20210825
     */
    public static void mtrace(TraceCtx ctx, Map<String, String> trInfo) {
    }

    /**
     * Http Call 관련 프로파일을 가지고 있는 {@link HttpCallCtx} 를 생성한다.
     *
     * @param host Http Call 호스트 정보
     * @param port Http Call 포트 정보
     * @param url  Http Call url 정보
     * @return Http Call 관련 프로파일을 가지고 있는 {@link HttpCallCtx}
     * @since agent v2.0_55-20210825
     */
    public static HttpCallCtx start(String host, int port, String url) {
        return null;
    }

    /**
     * 전달받은 {@link HttpCallCtx} 의 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다
     * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
     *
     * @param hctx   다른 작업에서 생성한 HttpCallCtx
     * @param status 응답코드 번호
     * @param reason 응답코드 상세내용
     * @param thr    에러정보
     * @since agent v2.0_55-20210825
     */
    public static void end(HttpCallCtx hctx, int status, String reason, Throwable thr) {
    }

    /**
     * Whatap 설정의 멀티추적기능 (mtrace_enabled) 활성화되어 있는 경우 멀티 추적을 위한 값을 추가한다.
     * Http Call 관련 프로파일을 가지고 있는 {@link HttpCallCtx} 를 생성한다.
     * 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다
     * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
     *
     * @param host    Http Call 호스트 정보
     * @param port    Http Call 포트 정보
     * @param url     Http Call url 정보
     * @param elapsed Http Call 응답시간
     * @param status  Http Call 응답코드
     * @param reason  Http Call 응답코드 내용
     * @param thr     Http Call 에러정보
     * @since agent v2.0_55-20210825
     */
    public static void trace(String host, int port, String url, int elapsed, int status, String reason, Throwable thr) {
    }

    /**
     * Whatap 설정의 멀티추적기능 (mtrace_enabled) 활성화되어 있는 경우 멀티 추적을 위한 값을 추가한다.
     * Http Call 관련 프로파일을 가지고 있는 {@link HttpCallCtx} 를 생성한다.
     * 프로파일 정보와 파라미터들을 저장하고 데이터 수집을 종료한다
     * 수집한 데이터를 와탭 모니터링 서비스로 전송한다.
     *
     * @param ctx     TraceCtx 정보
     * @param host    Http Call 호스트 정보
     * @param port    Http Call 포트 정보
     * @param url     Http Call url 정보
     * @param elapsed Http Call 응답시
     * @param status  Http Call 응답코드
     * @param reason  Http Call 응답코드 내용
     * @param thr     Http Call 에러정보
     * @since agent v2.0_57-20210831
     */
    public static void trace(TraceCtx ctx, String host, int port, String url, int elapsed, int status, String reason, Throwable thr) {
    }
}