package com.mt.remoting;

import com.mt.remoting.util.ProtocolUtils;

import java.net.Socket;
import java.util.Scanner;

public class Cli2 {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        try(Socket socket = new Socket("127.0.0.1",8090)){
            while(true) {
                Scanner scanner = new Scanner(System.in);
                String next = scanner.nextLine();
                System.out.println(next.length());
                byte[] protocol = ProtocolUtils.getProtocol(next.length(), next);
                socket.getOutputStream().write(protocol);
                int count = socket.getInputStream().read(buffer);
                System.out.println(count);
//                System.out.println(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
