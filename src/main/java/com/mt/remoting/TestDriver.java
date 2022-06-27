package com.mt.remoting;

import com.mt.remoting.server.GameServer;

public class TestDriver {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        gameServer.start(8090);
    }
}
