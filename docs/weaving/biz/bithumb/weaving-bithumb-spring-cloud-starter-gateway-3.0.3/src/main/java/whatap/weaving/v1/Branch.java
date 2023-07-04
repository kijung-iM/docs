package whatap.weaving.v1;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 트랜잭션의 쓰레드가 변경되어 새로운 쓰레드에 새로운 TraceCtx 가 필요한 경우 사용되는 API 클래스이다. 특히 병렬처리가
 * 이루어지는 트랜잭션의 경우 각각의 동시 처리 쓰레드를 위한 별도 {@link BranchCtx} 가 필요하다.
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class Branch {

	/**
	 * 전달받은 {@link TraceCtx} 을 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 생성하고
	 * sub-transaction 추적을 시작한다.
	 * 
	 * @param pctx 전달받은 TraceCtx 객체
	 * @return 새로운 생성한 BranchCtx
	 * @since agent v2.0_55-20210825
	 */
	public static BranchCtx start(TraceCtx pctx) {
		return null;
	}

	/**
	 * sub-transaction 추적을 종료한다. {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 start()에서
	 * 전달되었던 {@link TraceCtx} 에 복사된다.
	 *
	 * @param pctx BranchCtx 객체
	 * @since agent v2.0_55-20210825
	 */
	public static void end(BranchCtx pctx) {
	}

	/**
	 * 새로운 쓰레드에서 {@link Runnable} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Runnable.run()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터로 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 *
	 * @param pctx   TraceCtx 정보
	 * @param origin Runnable 객체
	 * @return Wrapping 된 Runnable 객체
	 * @since agent v2.0_55-20210825
	 */
	public static Runnable run(TraceCtx pctx, Runnable origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Runnable} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Runnable.run()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param origin Runnable 객체
	 * @return Wrapping 된 Runnable 객체
	 * @since agent v2.0_55-20210825
	 */
	public static Runnable run(Runnable origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Supplier} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Supplier.get()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin Supplier 객체
	 * @return Wrapping 된 Supplier 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Supplier<T> supply(TraceCtx pctx, Supplier<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Supplier} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Supplier.get()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 *
	 * @param origin Supplier 객체
	 * @return Wrapping 된 Supplier 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Supplier<T> supply(Supplier<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Consumer} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Consumer.accept()가 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin Consumer 객체
	 * @return Wrapping 된 Supplier 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Consumer<T> action(final TraceCtx pctx, final Consumer<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Consumer} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Consumer.accept()가 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param origin Consumer 객체
	 * @return Wrapping 된 Consumer 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Consumer<T> action(final Consumer<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Callable} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Callable.call()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin Consumer 객체
	 * @return Wrapping 된 Callable 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Callable<T> call(TraceCtx pctx, Callable<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Callable} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Callable.call()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param origin Callable 객체
	 * @return Wrapping 된 Callable 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Callable<T> call(Callable<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Future} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Future.get()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin Future 객체
	 * @return Wrapping 된 Future 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Future<T> future(final TraceCtx pctx, final Future<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Future} 객체가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Future.get()이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param origin Future 객체
	 * @return Wrapping 된 Future 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T> Future<T> future(final Future<T> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Function} 이 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 새로운
	 * 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Function 이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin 수행할 Function 객체
	 * @return Wrapping 된 Function 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T, R> Function<? super T, R> func(TraceCtx pctx, Function<? super T, R> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 {@link Function} 이 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다. 현재
	 * 수행중인 쓰레드의 TraceCtx 를 기반으로 새로운 쓰레드를 위한 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을
	 * 추적한다. Function 이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 부모 쓰레드의
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param origin 수행할 Function 객체
	 * @return Wrapping 된 Function 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T, R> Function<? super T, R> func(Function<? super T, R> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 WebFlux {@link Mono} 가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다.
	 * 새로운 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Function 이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin 수행할 Function<? super T, Mono<R>> 객체
	 * @return Wrapping 된 Function<? super T, Mono<R>> 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T, R> Function<? super T, Mono<R>> mono(TraceCtx pctx, Function<? super T, Mono<R>> origin) {
		return origin;
	}

	/**
	 * 새로운 쓰레드에서 WebFlux {@link Flux} 가 수행되는 동안 새로운(자식) TraceCtx 를 생성하고 유지한다.
	 * 새로운 쓰레드가 실행되면 전달된 TraceCtx 를 기반으로 {@link BranchCtx} 를 만들고 트랜잭션 수행 내용을 추적한다.
	 * Function 이 종료되면 {@link BranchCtx} 에 수집된 트랜잭션 프로파일 정보는 파라미터 전달되었던
	 * {@link TraceCtx} 에 복사된다.
	 * 
	 * @param pctx   TraceCtx 정보
	 * @param origin 수행할 Function<? super T, Flux<R>> 객체
	 * @return Wrapping 된 Function<? super T, Flux<R>> 객체
	 * @since agent v2.0_55-20210825
	 */
	public static <T, R> Function<? super T, Flux<R>> flux(TraceCtx pctx, Function<? super T, Flux<R>> origin) {
		return origin;
	}
}
