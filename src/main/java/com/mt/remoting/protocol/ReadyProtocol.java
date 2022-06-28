package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;

@ProtocolComponent(name = "Ready")
public class ReadyProtocol extends BroadCastProtocol{
    public ReadyProtocol(){
        protocolName = "Ready";
    }
    @Override
    public void execute(Conn conn) {
        String protocolWhole = protocolName+":"+protocolMsg;
        byte[] protocol = ProtocolUtils.getProtocol(protocolWhole.length(), protocolWhole);
        conn.setReady(protocol);
        super.execute(conn);
    }

    @Override
    public void doOther(Conn conn) {
        synchronized (GameServer.activeLink) {
            for (Conn conn1 : GameServer.activeLink) {
                if (conn1.getId() != conn.getId()) {
                    try {
                        conn.getSocket().getOutputStream().write(conn1.getReady());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
