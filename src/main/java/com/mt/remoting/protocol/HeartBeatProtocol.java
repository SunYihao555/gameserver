package com.mt.remoting.protocol;

import com.mt.remoting.server.Conn;

public class HeartBeatProtocol extends Protocol{
    public HeartBeatProtocol() { ;
        protocolName = "heart beat";
    }

    @Override
    public void execute(Conn conn) {
        System.out.println(conn.getId()+"执行了心跳协议");
        conn.lastAsyncTime = System.currentTimeMillis();
    }
}
