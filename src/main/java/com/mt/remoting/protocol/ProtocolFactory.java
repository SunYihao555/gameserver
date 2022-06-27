package com.mt.remoting.protocol;

import java.util.HashMap;
import java.util.Map;

//TODO 不满足open close 后期优化可以使用注解加反射对协议进行实例化
public class ProtocolFactory {
    public static Map<String,Protocol> protocolMap = new HashMap<>();
    static {
        protocolMap.put("update pos",new UpdatePosProtocol());
        protocolMap.put("heart beat",new HeartBeatProtocol());
    }


    public static Protocol getProtocol(String protocolName,String protocol){
        Protocol resProtocol = protocolMap.get(protocolName);
        resProtocol.setProtocolMsg(protocol);
        return resProtocol;


    }
}
