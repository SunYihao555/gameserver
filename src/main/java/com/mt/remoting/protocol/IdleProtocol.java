package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "Idle")
public class IdleProtocol extends Protocol{
    public IdleProtocol(){
        protocolName = "Idle";
    }
    @Override
    public void execute(Conn conn) {

    }
}
