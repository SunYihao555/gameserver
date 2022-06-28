package com.mt.remoting.room;

import com.mt.remoting.exception.GameException;
import com.mt.remoting.server.Conn;
import com.mt.remoting.util.ProtocolUtils;

import java.util.Random;
import java.util.UUID;
import java.util.Vector;

public  abstract class Room {
    private int maxSize;
    private String uuid;
    Vector<Conn> readyQueue;
    public Vector<Conn> getQueue(){
        return readyQueue;
    }
    public Room(int maxSize){
        uuid  = UUID.randomUUID().toString().replaceAll("-", "");
        this.maxSize = maxSize;
        readyQueue = new Vector(maxSize);
    }
    public String getUuid(){
        return uuid;
    }
    public void remove(Conn conn){
        readyQueue.remove(conn);
    }
    public void add(Conn conn){
        if(readyQueue.size()>=maxSize){
            throw new GameException("房间人数已满");
        }else{
            readyQueue.add(conn);
        }
    }
    public int getCount(){
        return readyQueue.size();
    }


}
