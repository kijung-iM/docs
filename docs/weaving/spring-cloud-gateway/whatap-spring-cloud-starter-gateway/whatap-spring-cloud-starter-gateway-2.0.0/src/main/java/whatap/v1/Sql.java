package whatap.v1;

/**
 * {@link SqlCtx} 를 생성, 설정, 할당하여 와탭 모니터링 서비스에 비동기 SQL 작업 데이터를 하나의 작업으로 연계하여 수집한다.
 *
 * @author Whatap
 */
public class Sql {

	/**
	 * 데이터베이스 호스트 정보, 데이터베이스 SQL 을 전달 받고, 새로운 {@link SqlCtx} 를 생성한다.
	 *
	 * @param dbhost 데이터베이스 호스트 정보
	 * @param sql 데이터베이스 SQL
	 * @return 비동기 SQL 작업에 전달할 {@link SqlCtx}
	 */
	public static SqlCtx start(String dbhost, String sql) {
		return null;
	}

	/**
	 * 데이터베이스 호스트 정보, 데이터베이스 SQL, SQL 에 사용할 기타 파라미터를 전달 받고, 새로운 {@link SqlCtx} 를 생성한다.
	 * 
	 * @param dbhost 데이터베이스 호스트 정보
	 * @param sql 데이터베이스 SQL
	 * @param param 데이터베이스 SQL 파라미터
	 * @return 비동기 SQL 작업에 전달할 {@link SqlCtx}
	 */
	public static SqlCtx start(String dbhost, String sql, String param) {
		return null;
	}

	/**
	 * 와탭 모니터링 서비스의 SQL 프로파일 정보와 에러정보를 저장하고 해당 SqlCtx 의 정보수집을 종료한다.
	 * 저장한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * 
	 * @param sctx 종료할 SqlCtx
	 * @param thr 에러정보
	 */
	public static void end(SqlCtx sctx, Throwable thr) {
	}

	/**
	 * 데이터베이스 호스트 정보, 데이터베이스 SQL 을 전달 받고, 새로운 {@link SqlCtx} 를 생성한다.
	 * 와탭 모니터링 서비스의 SQL 프로파일 정보와 에러정보를 저장하고 해당 SqlCtx 의 정보수집을 종료한다.
	 * 저장한 데이터를 와탭 모니터링 서비스로 전송한다.
	 * 
	 * @param dbhost 데이터베이스 호스트 정보
	 * @param sql 데이터베이스 SQL
	 * @param param 데이터베이스 SQL 파라미터
	 * @param elapsed 데이터베이스 응답시간
	 * @param thr 에러정보
	 */
	public static void trace(String dbhost, String sql, String param, int elapsed, Throwable thr) {
	}

}
