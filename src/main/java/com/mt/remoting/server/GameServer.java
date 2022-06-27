package com.mt.remoting.server;

import com.mt.remoting.runnable.ConnHandleRunnable;
import com.mt.remoting.task.CheckTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class GameServer {
    Conn[] conns;
    public static List<Conn> activeLink = new ArrayList<>();
    private static final int MAX_LENGTH = 50;

    public GameServer(){
        conns = new Conn[MAX_LENGTH];
        for(int i = 0;i<MAX_LENGTH;i++){
            Conn conn = new Conn(i);
            conns[i] = conn;
        }

    }


    public void start(int port){
//        定时器,定时检查心跳包
//        Timer timer = new Timer();
//        timer.schedule(new CheckTask(3000l),3000,3000);
        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket cli;
            while((cli = serverSocket.accept())!=null){
                Conn conn = null;
                for(int i = 0;i<MAX_LENGTH;i++){
                    if(!conns[i].isUsed){
                        conn = conns[i];
                        activeLink.add(conn);
                        break;
                    }
                }
                if(null==conn){
                    System.out.println("连接数已满");
                    continue;
                }
                conn.init(cli);
                new Thread(new ConnHandleRunnable(conn)).start();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
