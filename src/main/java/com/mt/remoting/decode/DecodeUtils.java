package com.mt.remoting.decode;

import com.mt.remoting.encode.EncodeUtils;
import com.mt.remoting.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class DecodeUtils {
    public static byte[] bytes = new byte[1024];
    public static String getProtocol(InputStream inputStream) throws IOException {
        inputStream.read(bytes,0,4);

        int length = EncodeUtils.byteArrayToInt(bytes);

        if (length==0) throw new RuntimeException("服务端已断开连接");

        inputStream.read(bytes,0,length);


        return new String(bytes,0,length);
    }

}
