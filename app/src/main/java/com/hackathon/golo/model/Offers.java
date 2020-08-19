package com.hackathon.golo.model;

import com.google.gson.annotations.SerializedName;

public class Offers {

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("description")
    private String description;


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
