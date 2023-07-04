package hone.bom.web.simple.message;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
abstract public class MessageHeader {
    abstract public String getGlobalNo();
}
