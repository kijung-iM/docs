package whatap.v1;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 설정한 {@link TraceCtx} 를 비동기로 동작하는 thread 에 넘겨주기 위한 작업을 실행한다.
 * 
 * @author Whatap
 */
public class Branch {
	
	/**
	 * {@link BranchCtx} 를 생성하고 전달받은 TraceCtx 의 비동기 작업에 대한 프로파일 정보 수집을 시작한다.
	 * TraceCtx 의 정보를 새로 생성한 BranchCtx 에 전달하여 TraceCtx 를 전달한 thread 와 함께 연계 추적한다.
	 * 
	 * @param pctx 전달받은 TraceCtx
	 * @return 새로운 생성한 BranchCtx
	 */
	public static BranchCtx start(TraceCtx pctx) {
		return null;
	}

	/**
	 * BranchCtx 의 정보를 {@link TraceCtx} 에 저장하고 BranchCtx 의 정보수집을 종료한다.
	 *
	 * @param bctx BranchCtx 정보
	 */
	public static void end(BranchCtx bctx) {
	}

	/**
	 * Runnable 활용하여 비동기 작업을 할 때 연계하여 추적하기 위한 용도이다.
	 * 개발자가 호출할 Runnable 함수를 호출하고 BranchCtx 의 정보를 TraceCtx 에 저장하고 BranchCtx 정보 수집을 종료한다.
	 *
	 * @param pctx TraceCtx 정보
	 * @param orgin 개발자가 호출할 Runnable 함수
	 * @return TraceCtx 정보와 함께 전달받은 Runnable 함수를 호출한다.
	 */
	public static <T> Runnable run(TraceCtx pctx, Runnable orgin) {
		return orgin;
	}

	/**
	 * Callable 활용하여 비동기 작업을 할 때 연계하여 추적하기 위한 용도이다.
	 * 개발자가 호출할 Callable 함수를 호출하고 BranchCtx 정보를 TraceCtx 에 저장하고 BranchCtx 정보 수집을 종료한다.
	 *
	 * @param pctx TraceCtx 정보
	 * @param orgin 개발자가 호출할 Callable 함수
	 * @return TraceCtx 정보와 함께 전달받은 Callable 함수를 호출한다.
	 */
	public static <T> Callable<T> call(TraceCtx pctx, Callable<T> orgin) {
		return orgin;
	}

	/**
	 * 병렬스트림(parallel, parallelStream) 등 비동기 작업을 할 때 연계하여 추적하기 위한 용도이다.
	 * 개발자가 호출할 Function 함수를 호출하고 BranchCtx 정보를 TraceCtx 에 저장하고 BranchCtx 정보 수집을 종료한다.
	 *
	 * @param pctx TraceCtx 정보
	 * @param orgin 개발자가 호출할 Callable 함수
	 * @return TraceCtx 정보와 함께 전달받은 Function 함수를 호출한다.
	 */
	public static <T, R> Function<? super T, R> func(TraceCtx pctx, Function<? super T, R> orgin) {
		return orgin;
	}

	/**
	 * Webflux 의 Flux 를 활용하여 비동기 작업을 할 때 연계하여 추적하기 위한 용도이다.
	 * 개발자가 호출할 Flux 를 호출하고 BranchCtx 정보를 TraceCtx 에 저장하고 BranchCtx 정보 수집을 종료한다.
	 *
	 * @param pctx TraceCtx 정보
	 * @param orgin 개발자가 호출할 Flux
	 * @return TraceCtx 정보와 함께 전달받은 Flux 를 호출한다.
	 */
	public static <T, R> Function<? super T, Mono<R>> mono(TraceCtx pctx, Function<? super T, Mono<R>> orgin) {
		return orgin;
	}

	/**
	 * Webflux 의 Mono 를 활용하여 비동기 작업을 할 때 연계하여 추적하기 위한 용도이다.
	 * 개발자가 호출할 Mono 를 호출하고 BranchCtx 정보를 TraceCtx 에 저장하고 BranchCtx 정보 수집을 종료한다.
	 *
	 * @param pctx TraceCtx 정보
	 * @param orgin 개발자가 호출할 Mono
	 * @return TraceCtx 정보와 함께 전달받은 Mono 를 호출한다.
	 */
	public static <T, R> Function<? super T, Flux<R>> flux(TraceCtx pctx, Function<? super T, Flux<R>> orgin) {
		return orgin;
	}
}
