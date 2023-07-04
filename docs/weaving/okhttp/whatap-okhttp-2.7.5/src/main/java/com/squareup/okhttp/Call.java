package com.squareup.okhttp;

import java.io.IOException;

import whatap.agent.Logger;
import whatap.agent.api.trace.TxHttpC;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class Call {
    Request originalRequest;

    public Response execute() throws IOException {
        Response resp = null;
        Object stat = null;
        Throwable thr = null;
        try {
            if (originalRequest != null) {
                try {
                    HttpUrl u = originalRequest.httpUrl();
                    stat = TxHttpC.startHttpc(u.host(), u.port(), u.uri().getPath());
                } catch (Throwable t) {
                    try {
                        Logger.println("okhttp-2.7.5", 10, t.getMessage());
                    } catch (Throwable tt) {
                    }
                }
            }
            resp = OriginMethod.callIOException();
        } catch (IOException e) {
            thr = e;
            throw e;
        } finally {
            try {
                TxHttpC.endHttpc(stat, resp.code(), resp.message(), thr);
            } catch (Throwable t) {
                try {
                    Logger.println("okhttp-2.7.5", 10, t.getMessage());
                } catch (Throwable tt) {
                }
            }
        }
        return resp;
    }

}
