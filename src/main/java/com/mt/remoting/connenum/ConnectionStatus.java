package com.mt.remoting.connenum;

public enum  ConnectionStatus {
    ONLINE("在线"),OUTLINE("离线");

    private final String name;

    private ConnectionStatus(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
