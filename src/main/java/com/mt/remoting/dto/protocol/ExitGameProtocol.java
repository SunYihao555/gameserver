package com.mt.remoting.dto.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "exit")
public class ExitGameProtocol extends Protocol{
    public ExitGameProtocol(){
        protocolName=  "exit";
    }

    @Override
    public void execute(Conn conn) {

    }
}
