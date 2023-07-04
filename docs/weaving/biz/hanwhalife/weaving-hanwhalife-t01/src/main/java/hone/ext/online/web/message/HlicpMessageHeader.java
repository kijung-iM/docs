package hone.ext.online.web.message;

import whatap.agent.api.weaving.SkipLoad;

@SkipLoad
abstract public class HlicpMessageHeader {
    abstract public String getGlobalNo();
}
