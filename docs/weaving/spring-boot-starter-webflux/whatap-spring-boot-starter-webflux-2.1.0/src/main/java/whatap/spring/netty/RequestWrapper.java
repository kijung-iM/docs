package whatap.spring.netty;

import java.net.InetSocketAddress;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import whatap.agent.Configure;
import whatap.agent.api.trace.Request;
import whatap.agent.api.util.EmptyEnumeration;
import whatap.agent.api.util.IteratorEnumeration;
import whatap.agent.conf.ConfUser;
import whatap.util.HashUtil;
import whatap.util.StringUtil;

public class RequestWrapper implements Request {
    HttpServerRequest req;
    HttpServerResponse resp;

    public RequestWrapper(HttpServerRequest req, HttpServerResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    @Override
    public Enumeration getHeaderNames() {
        Set<String> names = this.req.requestHeaders().names();
        return new IteratorEnumeration<String>(names.iterator());
    }

    protected Map<String, String> params;

    @Override
    public Enumeration getParameterNames() {
        prepareParameter();
        return new IteratorEnumeration<String>(params.keySet().iterator());
    }

    protected void prepareParameter() {
        if (params == null) {
            params = this.req.params();
            if (params == null) {
                params = new HashMap<String, String>();
            }
        }
    }

    @Override
    public String getHeader(String key) {
        return this.req.requestHeaders().get(key);
    }

    @Override
    public String getParameter(String key) {
        prepareParameter();
        return this.params.get(key);
    }

    String uri;

    @Override
    public String getRequestURI() {
        if (uri == null) {
            this.uri = StringUtil.cutOut(req.uri(), "?");
        }
        return this.uri;
    }

    @Override
    public StringBuffer getRequestURL() {
        return new StringBuffer(getRequestURI());
    }


    @Override
    public String getMethod() {
        return req.method().name();
    }

    @Override
    public String getQueryString() {
        return req.uri();
    }

    @Override
    public String getContentType() {
        return req.requestHeaders().get("Content-Type");
    }

    @Override
    public String getRemoteAddr() {
        InetSocketAddress addr = req.remoteAddress();
        return addr == null ? "0.0.0.0" : addr.getAddress().getHostAddress();
    }

    @Override
    public void setCharacterEncoding(String enc) {
        //
    }

    Configure conf = Configure.getInstance();

    @Override
    public long getWClientId() {
        switch (ConfUser.wclient_trace_type) {

            case ConfUser.IP: {
                String addr = this.getRemoteAddr();
                if (addr != null && addr.length() > 0) {
                    return HashUtil.hash(addr);
                }
                return 0;
            }
            case ConfUser.HEADER: {
                String ticket = this.getHeader(ConfUser.wclient_header_key);
                if (ticket != null && ticket.length() > 0) {
                    return HashUtil.hash(ticket);
                }
                return 0;
            }
        }
        return 0;
    }

}
