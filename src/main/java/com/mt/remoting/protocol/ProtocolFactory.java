package com.mt.remoting.protocol;

import com.mt.remoting.annotation.ProtocolComponent;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//TODO 不满足open close 后期优化可以使用注解加反射对协议进行实例化
public class ProtocolFactory {
    public static Map<String,Protocol> protocolMap = new ConcurrentHashMap<>();
    static {
        String basePackage = "com.mt.remoting.protocol";
        URL resource = ProtocolFactory.class.getClassLoader().getResource(basePackage.replaceAll("\\.","/"));
        String path = resource.getFile();
        File listFile = new File(path);
        for (File file : listFile.listFiles()) {
            if(!file.isDirectory()){
               String className = basePackage+"."+file.getName().replaceAll(".class","");
                try {
                    Class<?> clazz = Class.forName(className);
                    if(clazz.isAnnotationPresent(ProtocolComponent.class)){
                        ProtocolComponent protocolComponent = clazz.getAnnotation(ProtocolComponent.class);
                        String name = protocolComponent.name();
                        protocolMap.put(name, (Protocol) clazz.newInstance());
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static Protocol getProtocol(String protocolName,String protocol){
        Protocol resProtocol = protocolMap.get(protocolName);
        resProtocol.setProtocolMsg(protocol);
        return resProtocol;


    }
}
