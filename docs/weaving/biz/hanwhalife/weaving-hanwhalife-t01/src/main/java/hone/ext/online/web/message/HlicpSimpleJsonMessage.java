package hone.ext.online.web.message;

import hone.bom.web.simple.message.MessageHeader;
import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
abstract public class HlicpSimpleJsonMessage {
    abstract public MessageHeader getHeader();
}
