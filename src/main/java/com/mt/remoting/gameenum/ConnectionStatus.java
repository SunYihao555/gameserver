package com.mt.remoting.gameenum;

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
