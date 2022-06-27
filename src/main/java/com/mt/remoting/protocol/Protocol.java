package com.mt.remoting.protocol;

import com.mt.remoting.server.Conn;

public abstract class Protocol {
    protected String protocolMsg;
    protected String protocolName;
    public Protocol(){

    }
    public void setProtocolMsg(String protocolMsg){
        this.protocolMsg = protocolMsg;
    }
    public abstract void execute(Conn conn);
}
