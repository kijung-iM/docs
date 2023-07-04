package org.slf4j;

import whatap.agent.Logger;
import whatap.agent.api.Ref;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class MDC {
    static {
        try {
            Ref.c = MDC.class;
        } catch (Throwable t) {
            Logger.println("Ref.c not loaded", t);
        }
    }
}
