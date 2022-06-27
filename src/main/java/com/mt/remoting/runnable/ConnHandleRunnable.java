package com.mt.remoting.runnable;

import com.mt.remoting.encode.EncodeUtils;
import com.mt.remoting.protocol.ProtocolFactory;
import com.mt.remoting.server.Conn;

import java.io.UnsupportedEncodingException;

public class ConnHandleRunnable implements Runnable{
    private Conn conn;
    public ConnHandleRunnable(Conn conn){
        this.conn = conn;
    }
    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
            byte[] bytes;
            try {
                bytes = conn.readInt32();
            }catch (RuntimeException e){
                break;
            }
            System.out.println(EncodeUtils.byteArrayToInt(bytes));
            String protocol = conn.read(EncodeUtils.byteArrayToInt(bytes));
            if(protocol.equals("shut down")){
                break;
            }
            System.out.println(protocol);
            conn.execute(ProtocolFactory.getProtocol(protocol.split(":")[0],protocol.split(":")[1]));
        }
        System.out.println("连接中断");
        conn.close();

    }
}
