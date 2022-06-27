package com.mt.remoting.runnable;

import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;
import java.io.InputStream;

public class HandleResponseRunnable implements Runnable{
    private InputStream inputStream;
    public HandleResponseRunnable(InputStream inputStream){
        this.inputStream = inputStream;
    }
    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        while(true){
            try {
                inputStream.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(String.valueOf(buffer));


        }

    }
}
