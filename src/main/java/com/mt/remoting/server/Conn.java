package com.mt.remoting.server;

import com.mt.remoting.encode.EncodeUtils;
import com.mt.remoting.protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Arrays;

public class Conn {
    private int id;
    private Socket socket;
    private byte[] buffer;
    public boolean isUsed;
    private static final int BUFFER_SIZE = 1024;
    public long lastAsyncTime;
    private int pointer;
//    public void read(){
//        try {
//
//            socket.getInputStream().;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public int getId(){
        return id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }
    public String read(int length){
        char[] chars = new char[length];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            br.read(chars,0,length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(chars);

    }
    public byte[] readInt32(){
        try {
            this.socket.getInputStream().read(buffer,0,4);
        } catch (IOException e) {
            throw new RuntimeException("连接异常关闭");
        }
        return buffer;

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
        pointer = 0;
    }
    public void execute(Protocol protocol){
        protocol.execute(this);
    }
    public void close(){
        try {
            socket.close();
            isUsed = false;
            GameServer.activeLink.remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
