package com.diu.finalproject.dietplan.UserModel;

public class TipsModel {
    private String name,desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TipsModel(String name, String desc) {

        this.name = name;
        this.desc = desc;
    }
}
