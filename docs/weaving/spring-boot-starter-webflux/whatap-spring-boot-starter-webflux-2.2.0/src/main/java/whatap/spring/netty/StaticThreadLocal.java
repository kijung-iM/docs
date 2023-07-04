package whatap.spring.netty;

import org.springframework.web.reactive.function.client.ClientResponse;

public class StaticThreadLocal {
    public static ThreadLocal<ClientResponse> cache = new ThreadLocal<ClientResponse>();

    public static void put(ClientResponse r) {
        cache.set(r);
    }

    public static ClientResponse get() {
        ClientResponse out = cache.get();
        cache.set(null);
        return out;
    }

    public static ThreadLocal<Long> stepIdTable = new ThreadLocal<Long>();

}
