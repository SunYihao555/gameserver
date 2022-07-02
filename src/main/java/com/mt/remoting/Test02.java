package com.mt.remoting;

import com.google.gson.Gson;
import com.mt.remoting.dto.response.Response;

import java.util.Vector;

public class Test02 {
    public static void main(String[] args) {
        Response response = Response.success("success login");
        Gson gson = new Gson();
        String s = gson.toJson(response);
        System.out.println(s);

    }
}
