package com.mt.remoting.task;

import com.mt.remoting.server.Conn;
import com.mt.remoting.server.GameServer;

import java.util.TimerTask;

public class CheckTask extends TimerTask {
    private long timeLimit;
    public CheckTask(Long timeLimit){
        this.timeLimit = timeLimit;
    }
    @Override
    public void run() {
        for (Conn conn : GameServer.activeLink) {
            synchronized (conn){
                if(System.currentTimeMillis()-conn.lastAsyncTime>timeLimit){
                    conn.close();
                    GameServer.activeLink.remove(conn);
                }
            }
        }
    }
}
