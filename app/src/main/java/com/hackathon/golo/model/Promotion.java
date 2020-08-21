package com.hackathon.golo.model;

import com.google.gson.annotations.Expose;

public class Promotion {

    private String id;
    private String image;
    private String name;
    private String description;
    private boolean favorite;
    private String typeCampaign;
    private String point;
    private String voucherDetail;
    private String redeemCode;

    public String getVoucherDetail() {
        return voucherDetail;
    }

    public void setVoucherDetail(String voucherDetail) {
        this.voucherDetail = voucherDetail;
    }

    public String getRedeemCode() {
        return redeemCode;
    }

    public void setRedeemCode(String redeemCode) {
        this.redeemCode = redeemCode;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getTypeCampaign() {
        return typeCampaign;
    }

    public void setTypeCampaign(String typeCampaign) {
        this.typeCampaign = typeCampaign;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
