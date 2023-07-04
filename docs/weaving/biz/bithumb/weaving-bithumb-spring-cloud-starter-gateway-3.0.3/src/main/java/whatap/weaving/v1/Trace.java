package whatap.weaving.v1;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * {@link TraceCtx} 를 생성, 설정, 할당하여 와탭 모니터링 서비스에 데이터를 전송할 수 있다.
 *
 * @author Whatap
 * @since agent v2.0_55-20210825
 */
public class Trace {

    /**
     * 새로운 쓰레드에서 {@link Runnable} 객체가 수행되는 동안 TraceCtx 를 유지한다. 현재 수행중인 쓰레드의 TraceCtx 를
     * 전달하여 트랜잭션 수행 내용을 추적한다.
     *
     * @param ctx TraceCtx 정보
     * @param org Runnable 객체
     * @return Wrapping 된 Runnable 객체
     * @since agent v2.0_57-20210831
     */
    public static Runnable run(final TraceCtx ctx, final Runnable org) {
        return org;
    }

    /**
     * 새로운 쓰레드에서 {@link Runnable} 객체가 수행되는 동안 TraceCtx 를 유지한다. 현재 수행중인 쓰레드의 TraceCtx 를
     * 전달하여 트랜잭션 수행 내용을 추적한다.
     *
     * @param org Runnable 객체
     * @return Wrapping 된 Runnable 객체
     * @since agent v2.0_57-20210831
     */
    public static Runnable run(final Runnable org) {
        return org;
    }

    /**
     * 새로운 쓰레드에서 {@link Function} 객체가 수행되는 동안 TraceCtx 를 유지한다. 현재 수행중인 쓰레드의 TraceCtx 를
     * 전달하여 트랜잭션 수행 내용을 추적한다.
     *
     * @param ctx TraceCtx 정보
     * @param org Function 객체
     * @return Wrapping 된 Function 객체
     * @since agent v2.0_57-20210831
     */
    public static <T, R> Function<? super T, R> func(final TraceCtx ctx, final Function<? super T, R> org) {
        return org;
    }

    /**
     * 새로운 쓰레드에서 {@link Function} 객체가 수행되는 동안 TraceCtx 를 유지한다. 현재 수행중인 쓰레드의 TraceCtx 를
     * 전달하여 트랜잭션 수행 내용을 추적한다.
     *
     * @param org Function 객체
     * @return Wrapping 된 Function 객체
     * @since agent v2.0_57-20210831
     */
    public static <T, R> Function<? super T, R> func(Function<? super T, R> org) {
        return org;
    }

    /**
     * 새로운 쓰레드에서 TraceCtx 를 생성하고 키값을 통해서 기존 TraceCtx 를 전달하여 기존 TraceCtx 정보를 유지한다.
     *
     * @param key 기존 TraceCtx의 키값
     * @return 추적 컨텍스트 TraceCtx
     * @since agent v2.0_57-20210831
     */
    public static TraceCtx detach(Object key) {
        return null;
    }

    /**
     * 키값을 전달하여 현재 쓰레드의 TraceCtx 정보를 저장한다.
     *
     * @param key 현재 쓰레드의 TraceCtx 정보의 키값
     * @since agent v2.0_57-20210831
     */
    public static void link(Object key) {
    }

    /**
     * TraceCtx 정보와 key 값을 전달하여 현재 쓰레드의 TraceCtx 정보를 저장한다.
     *
     * @param key 추적을 하기 위한 키값
     * @param ctx 추적 컨텍스트 TraceCtx
     * @since agent v2.0_57-20210831
     */
    public static void attach(Object key, TraceCtx ctx) {
    }

    /**
     * 현재 쓰레드에서 처리중인 트랜잭션에 대한 추적 컨텍스트 {@link TraceCtx} 를 조회한다.
     *
     * @return 추적 컨텍스트 TraceCtx
     * @since agent v2.0_55-20210825
     */
    public static TraceCtx context() {
        return null;
    }

    /**
     * 입력된 아이디를 가진 트랜잭션의 추적 컨텍스트 {@link TraceCtx} 를 조회한다.
     *
     * @return 추적 컨텍스트 TraceCtx
     * @since agent v2.0_55-20210825
     */
    public static TraceCtx context(long ctxId) {
        return null;
    }

    /**
     * 쓰레드 정보를 비워서 와탭 모니터링 서비스에 보낼 데이터를 수집하지 않는다.
     *
     * @since agent v2.0_55-20210825
     */
    public static void detach() {
    }

    /**
     * 전달받은 {@link TraceCtx} 를 통해 하나의 작업으로 연계할 수 있도록 설정한다.
     *
     * @param ctx 다른 쓰레드에서 생성한 TraceCtx
     * @since agent v2.0_55-20210825
     */
    public static void attach(TraceCtx ctx) {
    }

    /**
     * 현재 쓰레드에 {@link TraceCtx} 를 생성하고 와탭 모니터링 서비스의 프로파일 정보를 수집한다.
     *
     * @param title   프로파일 이름
     * @param message 프로파일 내용
     * @param elapsed 프로파일 소요시간
     * @param value   프로파일 부가정보
     * @since agent v2.0_55-20210825
     */
    public static void step(String title, String message, int elapsed, int value) {
    }

    /**
     * 전달받은 {@link TraceCtx} 에 와탭 모니터링 서비스의 프로파일 정보를 추가한다.
     *
     * @param ctx     다른 쓰레드에서 생성한 TraceCtx
     * @param title   프로파일 이름
     * @param message 프로파일 내용
     * @param elapsed 프로파일 소요시간
     * @param value   프로파일 부가정보
     * @since agent v2.0_55-20210825
     */
    public static void step(TraceCtx ctx, String title, String message, int elapsed, int value) {
    }

    /**
     * 새로운 {@link TraceCtx} 를 설정하고 추적정보를 수집한다.
     *
     * @param name 생성한 서비스 이름
     * @return 새로운 TraceCtx
     * @since agent v2.0_55-20210825
     */
    public static TraceCtx start(String name) {
        return null;
    }

    /**
     * {@link TraceCtx} 의 정보를 프로파일에 저장하고 추적정보를 비운다.
     *
     * @param ctx 다른 쓰레드에서 생성한 TraceCtx 정보
     * @param thr TraceCtx 의 예외
     * @since agent v2.0_55-20210825
     */
    public static void end(TraceCtx ctx, Throwable thr) {
    }

    /**
     * 추적중인 thread 정보를 프로파일에 저장하고 CompletableFuture 결과를 수행한다.
     *
     * @param c 수행할 CompletableFuture 객체
     * @return Wrapping 된 CompletableFuture 객체
     * @since agent v2.0_55-20210825
     */
    public static <T> CompletableFuture<T> complete(CompletableFuture<T> c) {
        return c;
    }
}
