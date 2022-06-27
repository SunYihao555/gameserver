package com.mt.remoting.encode;

public class EncodeUtils {
    //int转为位字节数组
    public static byte[] intToByte(int num)
    {
        return new byte[] {(byte)((num>>24)&0xff),(byte)((num>>16)&0xff),(byte)((num>>8)&0xff),(byte)(num&0xff)};
    }
    //字节数组转化为int
    public static int byteArrayToInt(byte[] arr)
    {
        return (arr[0]&0xff)<<24|(arr[1]&0xff)<<16|(arr[2]&0xff)<<8|(arr[3]&0xff);
    }
}
