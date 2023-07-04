package whatap.spring.netty;

import reactor.netty.http.server.HttpServerResponse;
import whatap.agent.api.trace.Response;

public class ResponseWrapper implements Response {

    private HttpServerResponse resp;

    public ResponseWrapper(HttpServerResponse resp) {
        this.resp = resp;
    }

    public int getStatus() {
        return this.resp.status().code();
    }

    public void sendRedirect(String url) {
        this.resp.sendRedirect(url);
    }

    public void sendMessage(String message) {

    }

    public void sendHtml(String html) {

    }

}
