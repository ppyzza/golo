package com.hackathon.golo.model;

import java.util.ArrayList;

public class PromotionModel {
    private int viewType;

    public int getViewType() {
        return viewType;
    }
    private ArrayList<Promotion> promotionArrayList;

    public ArrayList<Promotion> getPromotionArrayList() {
        return promotionArrayList;
    }

    public void setPromotionArrayList(ArrayList<Promotion> promotionArrayList) {
        this.promotionArrayList = promotionArrayList;
    }

}
