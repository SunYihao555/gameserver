package com.mt.remoting.task;

import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class CheckTask extends TimerTask {
    private long timeLimit;
    public CheckTask(Long timeLimit){
        this.timeLimit = timeLimit;
    }
    @Override
    public void run() {
        List<Conn> tmp = new ArrayList<>();
        for (Conn conn : GameServer.activeLink) {
            synchronized (conn){
                if(System.currentTimeMillis()-conn.lastAsyncTime>timeLimit){
                    System.out.println("关闭了"+conn.getId()+"的无效连接");
                    tmp.add(conn);
                }
            }
        }
        synchronized (GameServer.activeLink){
            for (Conn conn : tmp) {
                conn.close();
            }
        }
    }
}
