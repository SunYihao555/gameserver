package com.mt.remoting.room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoomManager {
    public static Map<String,Room> roomMap = new ConcurrentHashMap<>();

    public static void put(Room room){
        roomMap.put(room.getUuid(),room);
    }
    public static Room get(String uuid){
        return roomMap.get(uuid);
    }

}
