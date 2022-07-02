package com.mt.remoting.dto.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "enter game")
public class EnterGameProtocol extends Protocol{
    public EnterGameProtocol(){
        protocolName = "enter game";
    }
    @Override
    public void execute(Conn conn) {
        while(true){
            int length;
            try {
                length = conn.readProtocolLength();
            }catch (Exception e){
                break;
            }
            String protocol = conn.readProtocol(length);
            String[] split = protocol.split(":");
            if(split.length!=2||split[0]=="exit") break;
            conn.execute(conn.getProtocolFactory().getProtocol(split[0],split[1]));
        }

    }
}
