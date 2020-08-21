package com.hackathon.golo.accountfollow.model;

public class AccountPlanModel {

    private String name;
    private String detail;
    private String info;

    public AccountPlanModel(String name, String detail, String info) {
        this.name = name;
        this.detail = detail;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
