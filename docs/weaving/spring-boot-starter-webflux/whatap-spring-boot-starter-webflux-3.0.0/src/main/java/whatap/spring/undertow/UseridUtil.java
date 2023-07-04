/*
 *  Copyright 2015 the original author or authors.
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package whatap.spring.undertow;

import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;

import whatap.agent.Configure;
import whatap.agent.Logger;
import whatap.agent.conf.ConfUser;
import whatap.util.Hexa32;
import whatap.util.KeyGen;

public class UseridUtil {
    static Configure conf = Configure.getInstance();
    private static final String WHATAP_R = "WHATAP";

    public static long getUserid(RequestUndertow req, ServerHttpResponse res, long defValue) {
        try {
            String cookie = req.getHeader("Cookie");
            if (cookie != null) {
                int x1 = cookie.indexOf(WHATAP_R);
                if (x1 >= 0) {
                    String value = null;
                    int x2 = cookie.indexOf(';', x1);
                    if (x2 > 0) {
                        value = cookie.substring(x1 + WHATAP_R.length() + 1, x2);
                    } else {
                        value = cookie.substring(x1 + WHATAP_R.length() + 1);
                    }
                    try {
                        return Hexa32.toLong32(value);
                    } catch (Throwable th) {
                    }
                }
                if (cookie.length() >= ConfUser.trace_user_cookie_limit) {
                    return defValue;
                }
            }
            ResponseCookie c = ResponseCookie.from(WHATAP_R, Hexa32.toString32(KeyGen.next())).maxAge(Integer.MAX_VALUE).path("/").build();
            res.addCookie(c);
        } catch (Throwable t) {
            Logger.println("USER-TOKEN", 10, "" + t);
        }
        return 0;
    }

}
