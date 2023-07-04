package io.whatap.server.audit;

import whatap.agent.Logger;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.Map;

import static io.whatap.server.audit.WeaveConf.*;

@Weaving
public class AuditLogWeaving {
    public static void save(long pcode, long time, String logCategory, Map<String, String> tags, Map<String, String> fields, String content) {

        if (debug_audit_log_enabled) {
            Logger.println(AuditLogWeaving.class.getName() + "::save");
        }

        try {
            OriginMethod.call();
        } finally {
            if (audit_log_enabled) {
                LogBox logBox = new LogBox();
                logBox.time = time;
                // 파라미터로 전달되는 카테고리를 사용하는 기능은 추후 지원 예정
                logBox.category = "#Audit";
                logBox.tags = tags;
                logBox.tags.put("requestPcode", String.valueOf(pcode));
                logBox.fields = fields;
                logBox.content = content;

                // LogSink send
                LogSink.trace(logBox);

                if (debug_audit_log_enabled) {
                    Logger.println(logBox.toString());
                    Logger.println("--------------------------------------\n");
                }
            }
        }
    }
}
