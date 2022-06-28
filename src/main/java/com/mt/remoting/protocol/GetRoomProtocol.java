package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.room.Room;
import com.mt.remoting.room.RoomManager;
import com.mt.remoting.server.Conn;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;
import java.util.Map;

@ProtocolComponent(name = "get room")
public class GetRoomProtocol extends Protocol{

    public GetRoomProtocol(){
        protocolName = "get room";
    }

    @Override
    public void execute(Conn conn) {
        //返回的类型room list:21222 5,213123 4,3232 5,
//        System.out.println(conn.getId()+"查询房间");
        String protocol = "room list:";
        synchronized (RoomManager.class){
            for (Map.Entry<String, Room> entry : RoomManager.roomMap.entrySet()) {
                String uuid = entry.getKey();
                protocol+=uuid;
                protocol+=" ";
                Room room = entry.getValue();
                protocol+=room.getCount();
                protocol+=",";
            }
        }
        try {
            conn.getSocket().getOutputStream().write(ProtocolUtils.getProtocol(protocol.length(),protocol));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
