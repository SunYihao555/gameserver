package com.mt.remoting.dto.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.room.ReadyRoom;
import com.mt.remoting.room.RoomManager;
import com.mt.remoting.server.Conn;

@ProtocolComponent(name = "create room")
public class CreateRoomProtocol extends Protocol{

    public CreateRoomProtocol(){
        protocolName = "create room";
    }

    @Override
    public void execute(Conn conn) {
        //TODO 解析protocol
        //创建一个房间
        conn.setCurrentRoom(new ReadyRoom(5));
        RoomManager.put(conn.getCurrentRoom());




    }
}
