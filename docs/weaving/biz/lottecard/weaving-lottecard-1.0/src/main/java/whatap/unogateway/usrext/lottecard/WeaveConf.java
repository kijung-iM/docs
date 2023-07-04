package whatap.unogateway.usrext.lottecard;

import whatap.agent.Configure;
import whatap.lang.conf.ConfObserver;

public class WeaveConf {
    public static String eai_source_host = "localhost";
    public static int eai_source_port = 0;
    public static boolean eai_message_enabled = false;
    public static boolean eai_message_debug_enabled = false;

    static {
        try {
            apply();
        } catch (Throwable t) {
        }
        ConfObserver.add("EaiLotteCard.WhatapConf", new Runnable() {
            @Override
            public void run() {
                apply();
            }
        });
    }

    protected static void apply() {
        Configure conf = Configure.getInstance();

        eai_source_host = conf.getValue("eai_source_host", "localhost");
        eai_source_port = conf.getInt("eai_source_port", 0);
        eai_message_enabled = conf.getBoolean("eai_message_enabled", false);
        eai_message_debug_enabled = conf.getBoolean("eai_message_debug_enabled", false);
    }

    // 1.   com.lottecard.mca.adaptor.eai.UserEaiClientAdapter::sendAndResponse(Object client, UserAdapterDataChannel inout)
    // 1.1. EaiProxy proxy = UserEaiProxy.getInstance();
    // 1.2. EaiMessage rqmsg = EaiFactory.getInstance().newMessage();
    // 1.3. EaiMessage rsmsg = proxy.requestReply(emsqueue, rqmsg);
    //      2.   com.cspi.ems.impl.EaiProxyImpl::requestReply(String queueId, EaiMessage sendMsg)
    //      2.1. EaiMessage result = pitcher.requestReply(sendMsg, queueId);
    //      2.2. com.cspi.ems.impl.MessagePitcher::requestReply(EaiMessage msgobj, String qid)
    // 1.4. inout.setResponse(responseData);
}
