package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;

@ProtocolComponent(name = "attack")
public class AttackProtocol extends BroadCastProtocol{
    public AttackProtocol(){
        protocolName = "attack";
    }

}
