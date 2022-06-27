package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "map init")
public class MapInitProtocol extends Protocol{

    public MapInitProtocol(){
        protocolName = "map init";
    }
    @Override
    public void execute(Conn conn) {

    }
}
