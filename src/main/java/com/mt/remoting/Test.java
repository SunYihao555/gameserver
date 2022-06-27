package com.mt.remoting;

import com.mt.remoting.util.ProtocolUtils;
import javafx.concurrent.Task;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("处理心跳");
            }
        },1000,1000);
        for(int i = 0;i<100;i++){
            try {
                Thread.sleep(1000);

                System.out.println("客户端连接");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
