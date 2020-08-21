package com.hackathon.golo.model;

public class PlanModel {
    public String planName;
    public String destinationId;
    public String from;
    public String to;

    public PlanModel() {
    }

    public PlanModel(String planName, String destinationId, String from, String to) {
        this.planName = planName;
        this.destinationId = destinationId;
        this.from = from;
        this.to = to;
    }

    public String getPlanName() {
        return planName;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
