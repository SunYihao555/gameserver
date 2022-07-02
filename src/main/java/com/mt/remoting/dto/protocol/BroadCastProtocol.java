package com.mt.remoting.dto.protocol;

import com.mt.remoting.gameenum.ConnectionStatus;
import com.mt.remoting.server.Conn;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;

public abstract class BroadCastProtocol extends Protocol{
    @Override
    public void execute(Conn conn) {
        for (Conn conn1 : conn.getCurrentRoom().getQueue()) {
            if(conn1.getId()!=conn.getId()){
                String protocolWhole = protocolName + ":" + protocolMsg;
                byte[] protocol = ProtocolUtils.getProtocol(protocolWhole.length(), protocolWhole);
                synchronized (conn1) {
                    if (conn1.getConnStatus().equals(ConnectionStatus.ONLINE)) {
                        try {
                            conn1.getSocket().getOutputStream().write(protocol);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        //交给子类实现
        doOther(conn);
    }

    public void doOther(Conn conn){};
}
