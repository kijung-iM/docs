package io.whatap.server.audit;

import whatap.weaving.v1.WhatapConf;

import static whatap.weaving.v1.WhatapConf.getBoolean;

public class WeaveConf {
    public static String title_audit_log = "title_audit_log";

    public static Boolean audit_log_enabled = true;
    public static Boolean debug_audit_log_enabled = false;
    public static Boolean audit_log_origin_method_call_enabled = false;
//    public static String audit_log_custom_category = "#Audit";

    static {
        apply();
        WhatapConf.onModified(title_audit_log, new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        audit_log_enabled = getBoolean("audit_log_enabled", true);
        debug_audit_log_enabled = getBoolean("debug_audit_log_enabled", false);
        audit_log_origin_method_call_enabled = getBoolean("audit_log_origin_method_call_enabled", false);

        // 문자열 옵션은 파일에서 읽는 기능이 동작하지 않아서 카테고리는 고정적인 값을 사용하도록 처리함 2023-05-011
//        audit_log_custom_category = WhatapConf.get(audit_log_custom_category);
//        if (audit_log_custom_category == null || audit_log_custom_category.trim().isEmpty()) {
//            audit_log_custom_category = "#AuditLog";
//        }
    }
}
