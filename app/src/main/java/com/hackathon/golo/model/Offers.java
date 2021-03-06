package com.hackathon.golo.model;

import com.google.gson.annotations.SerializedName;

public class Offers {

    @SerializedName("id")
    private String id;

    @SerializedName("offer_title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("offer_description")
    private String description;

    @SerializedName("image")
    private String image;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
