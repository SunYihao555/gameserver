package com.mt.remoting.server;

import com.mt.remoting.encode.EncodeUtils;
import com.mt.remoting.gamebean.Player;
import com.mt.remoting.dto.protocol.Protocol;
import com.mt.remoting.dto.protocol.ProtocolFactory;
import com.mt.remoting.room.Room;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;
import java.net.Socket;

public class Conn {
    private ProtocolFactory protocolFactory;
    private Enum connStatus;
    private int id;
    private Room currentRoom;
    private Player player;

    private Socket socket;
    private byte[] buffer;
    public boolean isUsed;
    private static final int BUFFER_SIZE = 1024;
    public long lastAsyncTime;
    private int pointer;
    private byte[] ready;
    public void setPlayer(Player player){
        this.player = player;
    }

    public Enum getConnStatus() {
        return connStatus;
    }

    public void setConnStatus(Enum connStatus) {
        this.connStatus = connStatus;
    }

    public byte[] getReady() {
        return ready;
    }

    public void setReady(byte[] ready) {
        this.ready = ready;
    }


    public int getId(){
        return id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
        room.add(this);
    }
    public void enterRoom(Room room){
        setCurrentRoom(room);

    }
    public void exitRoom(){
        this.currentRoom.remove(this);
        this.currentRoom = null;
    }
    public Room getCurrentRoom(){return this.currentRoom;}

    public ProtocolFactory getProtocolFactory() {
        return protocolFactory;
    }

    public void setProtocolFactory(ProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public String read(int length){
        try {
            this.socket.getInputStream().read(buffer,pointer,length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer,pointer,length);

    }
    public String read2(){
        int readCount;
        try {
            readCount = this.socket.getInputStream().read(buffer);
        } catch (IOException e) {
            throw new RuntimeException("断开连接");
        }
        System.out.println(readCount);
        if(readCount==-1) throw new RuntimeException("没有数据");

        int i = EncodeUtils.byteArrayToInt(buffer);


        return new String(buffer,4,i);

    }

    //////////////////////////////
//    public String read(int length){
//        char[] chars = new char[length];
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//            br.read(chars,0,length);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return String.valueOf(chars);
//
//    }
    ///////////////////////////////

    public int readProtocolLength(){
        pointer = 0;
        try {
            this.socket.getInputStream().read(buffer,pointer,4);
        } catch (IOException e) {
            throw new RuntimeException("连接异常关闭");
        }
        pointer = 4;
        return EncodeUtils.byteArrayToInt(buffer);

    }
    public String readProtocol(int length){
        try {
            this.socket.getInputStream().read(buffer,pointer,length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer,pointer,length);
    }

    public void writeProtocol(String protocol) throws IOException {

        byte[] protocolBytes = ProtocolUtils.getProtocol(protocol.length(), protocol);
        socket.getOutputStream().write(protocolBytes);
        socket.getOutputStream().flush();

    }

    public Conn(int index){
        id = index;
        isUsed = false;

    }
    public void init(Socket socket){
        this.socket = socket;
        lastAsyncTime = System.currentTimeMillis();
        buffer = new byte[BUFFER_SIZE];
        isUsed = true;
        protocolFactory = new ProtocolFactory();
        pointer = 0;
    }
    public void execute(Protocol protocol){
        protocol.execute(this);
    }
    public void close(){
        try {
            socket.close();
            isUsed = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
