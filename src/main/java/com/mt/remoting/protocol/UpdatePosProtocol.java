package com.mt.remoting.protocol;

import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;

public class UpdatePosProtocol extends Protocol{

    public UpdatePosProtocol() {
        protocolName = "update pos";
    }

    @Override
    public void execute(Conn conn) {
        System.out.println(conn.getId()+"执行了更新位置的协议");
        for (Conn conn1 : GameServer.activeLink) {
            if(conn1.getId()!=conn.getId()){
                String protocolWhole = protocolName+":"+protocolMsg;
                byte[] protocol = ProtocolUtils.getProtocol(protocolWhole.length(), protocolWhole);
                synchronized (conn1){
                    try {
                        conn1.getSocket().getOutputStream().write(protocol);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
