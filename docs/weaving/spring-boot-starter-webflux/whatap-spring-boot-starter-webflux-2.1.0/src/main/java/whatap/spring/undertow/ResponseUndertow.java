package whatap.spring.undertow;

import org.springframework.http.server.reactive.ServerHttpResponse;

import whatap.agent.api.trace.Response;

public class ResponseUndertow implements Response {

    private ServerHttpResponse resp;

    public ResponseUndertow(ServerHttpResponse resp) {
        this.resp = resp;
    }

    public int getStatus() {
        return this.resp.getStatusCode().value();
    }

    public void sendRedirect(String url) {

    }

    public void sendMessage(String message) {

    }

    public void sendHtml(String html) {

    }

}
