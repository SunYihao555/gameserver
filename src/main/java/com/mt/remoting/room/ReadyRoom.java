package com.mt.remoting.room;

public class ReadyRoom extends Room{
    private String mapType;
    private String gameType;

    public ReadyRoom(int maxSize) {
        super(maxSize);
    }
}
