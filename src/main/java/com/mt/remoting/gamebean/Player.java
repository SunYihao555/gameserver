package com.mt.remoting.gamebean;

public class Player {
    //玩家id
    private int id;
    //玩家名字
    private String name;
    //玩家的人物形状(dragon,bat......)
    private String prefab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefab() {
        return prefab;
    }

    public void setPrefab(String prefab) {
        this.prefab = prefab;
    }
}
