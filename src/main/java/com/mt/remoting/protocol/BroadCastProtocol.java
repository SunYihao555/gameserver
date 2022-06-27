package com.mt.remoting.protocol;

import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;

public abstract class BroadCastProtocol extends Protocol{
    @Override
    public void execute(Conn conn) {
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
                    //交给子类实现
                    doOther();
                }
            }

        }
    }

    public void doOther(){};
}
