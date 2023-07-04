package whatap.weaving.v1;

/**
 * {@link TraceCtx} 를 상속받은 클래스타입으로 TraceCtx 와 비동기로 동작하는 작업의 정보를 수집한다.
 * BranchCtx 는 {@link TraceCtx} 를 전달받아 {@link Branch#start(TraceCtx)} 로 생성할 수 있다.
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class BranchCtx extends TraceCtx {

}
