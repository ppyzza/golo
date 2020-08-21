package com.hackathon.golo.model;

public class PlanModel {
    public String planName;
    public String destinationName;
    public String from;
    public String to;
    public Double lat;
    public Double lon;

    public PlanModel() {
    }

    public PlanModel(String planName, String destinationName, String from, String to, Double lat, Double lon) {
        this.planName = planName;
        this.destinationName = destinationName;
        this.from = from;
        this.to = to;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPlanName() {
        return planName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
