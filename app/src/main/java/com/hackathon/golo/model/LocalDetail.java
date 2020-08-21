package com.hackathon.golo.model;

import java.util.ArrayList;

public class LocalDetail {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlanReview() {
        return planReview;
    }

    public void setPlanReview(int planReview) {
        this.planReview = planReview;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlans() {
        return plans;
    }

    public void setPlans(int plans) {
        this.plans = plans;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public ArrayList<PlanList> getPlanListArrayList() {
        return planListArrayList;
    }

    public void setPlanListArrayList(ArrayList<PlanList> planListArrayList) {
        this.planListArrayList = planListArrayList;
    }

    private int planReview;
    private int hours;
    private String name;
    private int plans;
    private int review;
    private String price;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private int distance;

    private ArrayList<PlanList> planListArrayList;
}
