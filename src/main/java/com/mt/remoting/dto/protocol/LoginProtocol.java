package com.mt.remoting.dto.protocol;

import com.google.gson.Gson;
import com.mt.remoting.annotation.ProtocolComponent;
import com.mt.remoting.dto.response.Response;
import com.mt.remoting.gamebean.Player;
import com.mt.remoting.server.Conn;

import java.io.IOException;

@ProtocolComponent(name = "login")
public class LoginProtocol extends Protocol{
    public LoginProtocol(){
        protocolName = "login";
    }

    @Override
    public void execute(Conn conn) {
        String[] protocols = protocolMsg.split(" ");
        Player player = new Player();
        player.setId(Integer.parseInt(protocols[1]));
        player.setName(protocols[3]);
        player.setPrefab(protocols[5]);
        conn.setPlayer(player);

        Gson gson = new Gson();
        Response response = Response.success("success login");
        String s = gson.toJson(response);
        try {
            conn.getSocket().getOutputStream().write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
