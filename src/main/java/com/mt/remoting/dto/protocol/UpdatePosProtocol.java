package com.mt.remoting.dto.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "update pos")
public class UpdatePosProtocol extends BroadCastProtocol{

    public UpdatePosProtocol() {
        protocolName = "update pos";
    }

    @Override
    public void execute(Conn conn) {
        System.out.println(conn.getId()+"执行了更新位置");
        super.execute(conn);
    }
}
