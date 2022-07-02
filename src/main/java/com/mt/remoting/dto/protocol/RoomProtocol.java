package com.mt.remoting.dto.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.room.Room;
import com.mt.remoting.room.RoomManager;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "room")
public class RoomProtocol extends Protocol{
    //协议格式: room:0 uuid
    public RoomProtocol(){
        protocolName = "room";
    }
    @Override
    public void execute(Conn conn) {
        //进入房间退出房间的逻辑

        String[] protocols = protocolMsg.split(" ");
        Room room = RoomManager.get(protocols[1]);
        if (protocols[0].equals("0")) conn.setCurrentRoom(room);
        else conn.exitRoom();


    }
}
