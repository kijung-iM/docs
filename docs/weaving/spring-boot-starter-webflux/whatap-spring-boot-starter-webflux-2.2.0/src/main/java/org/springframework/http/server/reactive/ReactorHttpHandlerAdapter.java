package org.springframework.http.server.reactive;

import io.netty.handler.codec.http.HttpHeaders;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import whatap.agent.api.trace.TxStat;
import whatap.agent.api.trace.TxTrace;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.lang.ref.OBJECT;
import whatap.spring.netty.RequestWrapper;
import whatap.spring.netty.ResponseWrapper;

@Weaving
public class ReactorHttpHandlerAdapter {

    // Spring Cloud API Gateway 에서 HTTP 요청을 받았을때 트랜잭션 측정 시작 함수
    public Mono<Void> apply(HttpServerRequest reactorRequest, HttpServerResponse reactorResponse) {

    	// 측정 정보 생성
        final RequestWrapper req = new RequestWrapper(reactorRequest, reactorResponse);
        final ResponseWrapper res = new ResponseWrapper(reactorResponse);

        // 트랜잭션 측정 시작
        final TxStat stat = TxTrace.startHttpTx(req, res);
        Mono<Void> m = OriginMethod.call();

        if (stat != null) {
            // SpringApiGateway를 위해 전달해야함 spring-cloud-gateway-2.2.X
            HttpHeaders httpHeaders = reactorRequest.requestHeaders();
            httpHeaders.add("whatap_ctx_trace_id", Long.toString(stat.ctx.txid));
        }

        OBJECT<Throwable> th = new OBJECT<Throwable>();
        return m.doOnError(ex -> {
            th.value = ex;
        }).doFinally(aVoid -> {
            // Mono 최종 완료시 트랜잭션 종료
            TxTrace.endHttpTx(stat, th.value);
        });
    }
}
