package com.cspi.ems.impl;

import com.cspi.ems.EaiException;
import com.cspi.ems.EaiMessage;
import whatap.agent.api.trace.TxHttpC;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;
import whatap.agent.data.DataTextAgent;
import whatap.agent.trace.HttpcContext;
import whatap.lang.step.MessageStep;
import whatap.util.HashUtil;

import java.io.UnsupportedEncodingException;

import static whatap.unogateway.usrext.lottecard.WeaveConf.*;

@Weaving
public class EaiProxyImpl {

    public EaiMessage requestReply(String queueId, EaiMessage sendMsg) throws EaiException {
        HttpcContext hCtx = TxHttpC.startNonBlockHttpc(eai_source_host, eai_source_port, queueId);

        if (eai_message_enabled) {
            MessageStep p = new MessageStep();
            String hashStr = "lottecard_eai_request";
            p.hash = HashUtil.hash(hashStr);
            DataTextAgent.MESSAGE.add(p.hash, hashStr);

            if (eai_message_debug_enabled) {
                String debugRequestMessage;
                byte[] reqArray = sendMsg.getData();
                if (reqArray != null && reqArray.length > 0) {
                    debugRequestMessage = debugMessageToString(reqArray);
                    if (debugRequestMessage.length() > 0) {
                        p.desc = debugRequestMessage;
                    }
                }
            }
            hCtx.context.profile.add(p);
        }

        EaiMessage originResult = null;
        EaiException th = null;
        try {
            originResult = OriginMethod.callEaiException();
            return originResult;
        } catch (EaiException e) {
            th = e;
            throw e;
        } finally {
            if (hCtx != null) {
                if (eai_message_enabled) {
                    MessageStep p = new MessageStep();
                    String hashStr = "lottecard_eai_response";
                    p.hash = HashUtil.hash(hashStr);
                    DataTextAgent.MESSAGE.add(p.hash, hashStr);

                    if (eai_message_debug_enabled) {
                        String debugResponseMessage;
                        byte[] reqArray = sendMsg.getData();
                        if (reqArray != null && reqArray.length > 0) {
                            debugResponseMessage = debugMessageToString(reqArray);
                            if (debugResponseMessage.length() > 0) {
                                p.desc = debugResponseMessage;
                            }
                        }
                    }
                    hCtx.context.profile.add(p);
                }

                TxHttpC.endHttpc(hCtx, 0, "", th);
            }
        }
    }

    public static String debugMessageToString(byte[] bdata) {
        try {
            return new String(bdata, "EUC-KR");
        } catch (UnsupportedEncodingException e) {
            return new String(bdata);
        }
    }

}
