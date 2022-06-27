package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;

@ProtocolComponent(name = "update pos")
public class UpdatePosProtocol extends BroadCastProtocol{

    public UpdatePosProtocol() {
        protocolName = "update pos";
    }



}
