package io.home.test;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.weaving.v1.LogBox;
import whatap.weaving.v1.LogSink;

import java.util.HashMap;
import java.util.Map;

@Weaving
public class TestController {

    private static void getData(String login, int searchCount) {
        OriginMethod.call();

        /* */
        // LogSinkPack 만들기
        LogBox logBox = new LogBox();
        Map<String, String> tags = new HashMap();
        Map<String, String> fields = new HashMap();
        logBox.time = System.currentTimeMillis();
        if (login != null)      tags.put("login", login);
        if (searchCount > 0)    fields.put("searchCount", String.valueOf(searchCount));

        logBox.content = "log message body.....";
        logBox.category = "LogSinkRecord";
        logBox.tags = tags;
        logBox.fields = fields;
        System.out.println("logBox: " + logBox);

        // LogSink send
        LogSink.trace(logBox);
    }



//    private static void getData(String login, int searchCount) {
//        System.out.println(TestController.class.getName() + "::getData");
//        try {
//            OriginMethod.call();
//        } finally {
//            System.out.println("----------------------------\n\n");
//        }
//    }
}
