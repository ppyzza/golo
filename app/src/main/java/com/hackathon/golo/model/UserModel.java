package com.hackathon.golo.model;

public class UserModel {
    public String name;
    public Integer follow;
    public Integer point;

    public String getName() {
        return name;
    }

    public Integer getFollow() {
        return follow;
    }

    public Integer getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
