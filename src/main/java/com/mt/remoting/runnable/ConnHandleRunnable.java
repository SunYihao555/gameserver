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
//        while(true) {
//            byte[] bytes;
//            try {
//                bytes = conn.readInt32();
//            }catch (RuntimeException e){
//                break;
//            }
//            System.out.println(EncodeUtils.byteArrayToInt(bytes));
//            String protocol = conn.read(EncodeUtils.byteArrayToInt(bytes));
//            System.out.println(protocol);
//            if(protocol.equals("shut down")){
//                break;
//            }
//            String[] split = protocol.split(":");
//            System.out.println(split.length);
//            System.out.println("=======执行协议======");
//            if(split.length==2) {
//                conn.execute(ProtocolFactory.getProtocol(split[0], split[1]));
//            }
//        }
//        System.out.println("连接中断");
//        conn.close();

        while(true) {
//            int length;
//            try {
//                length = conn.readProtocolLength();
//            }catch (Exception e){
//                break;
//            }
//            System.out.println(length);
//            String protocol = conn.readProtocol(length);
            String protocol;
            try {
                protocol = conn.read2();
            }catch (Exception e){
                break;
            }
            System.out.println(protocol);
            String[] split = protocol.split(":");
            if(split.length==2) conn.execute(conn.getProtocolFactory().getProtocol(split[0],split[1]));

        }
        System.out.println("客户端断开连接");

        


    }
}
