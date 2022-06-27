package com.mt.remoting.util;

import com.mt.remoting.encode.EncodeUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ProtocolUtils {
    public static byte[] getProtocol(int length,String msg){
        byte[] bytes = new byte[1024];
        System.arraycopy(EncodeUtils.intToByte(length),0,bytes,0,4);
        try {
            System.arraycopy(msg.getBytes("UTF-8"),0,bytes,4,msg.getBytes().length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
