package com.mt.remoting.runnable;

import com.mt.remoting.decode.DecodeUtils;
import com.mt.remoting.util.ProtocolUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class HandleResponseRunnable implements Runnable{
    private InputStream inputStream;
    public HandleResponseRunnable(InputStream inputStream){
        this.inputStream = inputStream;
    }
    @Override
    public void run() {

        while(true){
            String protocol = null;
            try {
                protocol = DecodeUtils.getProtocol(inputStream);
            } catch (UnsupportedEncodingException | RuntimeException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            System.out.println(protocol);
        }
        System.out.println("不在接受消息");

    }
}
