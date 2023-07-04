package whatap.spring.undertow;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;

import whatap.agent.Configure;
import whatap.agent.api.trace.Request;
import whatap.agent.api.util.IteratorEnumeration;
import whatap.agent.conf.ConfUser;
import whatap.util.HashUtil;

public class RequestUndertow implements Request {
    ServerHttpRequest req;
    ServerHttpResponse resp;

    public RequestUndertow(ServerHttpRequest req, ServerHttpResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    @Override
    public Enumeration getHeaderNames() {
        Set<String> names = this.req.getHeaders().keySet();
        return new IteratorEnumeration<String>(names.iterator());
    }

    protected MultiValueMap<String, String> params;

    @Override
    public Enumeration getParameterNames() {
        prepareParameter();
        return new IteratorEnumeration<String>(params.keySet().iterator());
    }

    protected void prepareParameter() {
        if (params == null) {
            params = this.req.getQueryParams();
            if (params == null) {
                params = new MultiValueMap<String, String>() {

                    @Override
                    public int size() {
                        // TODO Auto-generated method stub
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        // TODO Auto-generated method stub
                        return false;
                    }

                    @Override
                    public boolean containsKey(Object key) {
                        // TODO Auto-generated method stub
                        return false;
                    }

                    @Override
                    public boolean containsValue(Object value) {
                        // TODO Auto-generated method stub
                        return false;
                    }

                    @Override
                    public List<String> get(Object key) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public List<String> put(String key, List<String> value) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public List<String> remove(Object key) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public void putAll(Map<? extends String, ? extends List<String>> m) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void clear() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public Set<String> keySet() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Collection<List<String>> values() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Set<Entry<String, List<String>>> entrySet() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public void add(String arg0, String arg1) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void addAll(MultiValueMap<String, String> arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void addAll(String arg0, List<? extends String> arg1) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public String getFirst(String arg0) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public void set(String arg0, String arg1) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void setAll(Map<String, String> arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public Map<String, String> toSingleValueMap() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                };
            }
        }
    }

    HttpHeaders headers;

    @Override
    public String getHeader(String key) {
        if (headers == null) {
            headers = this.req.getHeaders();
        }
        List<String> h = headers.get(key);
        if (h == null || h.size() == 0)
            return null;
        else
            return h.get(0);
    }

    @Override
    public String getParameter(String key) {
        prepareParameter();
        List<String> h = this.params.get(key);
        if (h == null || h.size() == 0)
            return null;
        else
            return h.get(0);
    }

    @Override
    public String getRequestURI() {
        return req.getURI().getPath();
    }

    @Override
    public StringBuffer getRequestURL() {
        return new StringBuffer(req.getURI().getRawPath());
    }

    @Override
    public String getMethod() {
        return req.getMethod().name();
    }

    @Override
    public String getQueryString() {
        return req.getURI().getQuery();
    }

    @Override
    public String getContentType() {
        return getHeader("Content-Type");
    }

    @Override
    public String getRemoteAddr() {
        InetSocketAddress addr = req.getRemoteAddress();
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
            case ConfUser.COOKIE: {
                UseridUtil.getUserid(this, resp, 0);
                return 0;
            }
        }
        return 0;
    }

}
