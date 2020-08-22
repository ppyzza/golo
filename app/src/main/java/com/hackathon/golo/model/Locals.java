package com.hackathon.golo.model;

public class Locals {

    public LocalDetail getLocalDetail() {
        return localDetail;
    }

    public void setLocalDetail(LocalDetail localDetail) {
        this.localDetail = localDetail;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    LocalDetail localDetail;
    private String viewType;

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    private boolean isPay = false;
}
