package com.mt.remoting.decode;

import com.mt.remoting.encode.EncodeUtils;
import com.mt.remoting.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class DecodeUtils {
    public static String getProtocol(InputStream inputStream) throws UnsupportedEncodingException {
        byte[] buffer = new byte[1024];
        try {
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int length = EncodeUtils.byteArrayToInt(buffer);
        System.out.println(length);
        int start = 4;
        byte[] res = new byte[length];
        for(int i = start;i<length+start;i++){
            res[i-start] = buffer[i];
        }
        return new String(res,"UTF-8");


    }
}
