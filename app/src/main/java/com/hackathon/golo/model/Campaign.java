package com.hackathon.golo.model;

import java.util.Date;
import java.util.List;

public class Campaign {
    private Object createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private String id;
    private String campaignCode;
    private String channel;
    private Object txRef;
    private List<ActionTx> actionTxs;
    private Attribute attribute;
    private Object cart;
    private String status;
    private boolean manualAcknowledge;
    private List<Error> errors;
    private String projectId;

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Object getTxRef() {
        return txRef;
    }

    public void setTxRef(Object txRef) {
        this.txRef = txRef;
    }

    public List<ActionTx> getActionTxs() {
        return actionTxs;
    }

    public void setActionTxs(List<ActionTx> actionTxs) {
        this.actionTxs = actionTxs;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Object getCart() {
        return cart;
    }

    public void setCart(Object cart) {
        this.cart = cart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isManualAcknowledge() {
        return manualAcknowledge;
    }

    public void setManualAcknowledge(boolean manualAcknowledge) {
        this.manualAcknowledge = manualAcknowledge;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<Object> getActionRefs() {
        return actionRefs;
    }

    public void setActionRefs(List<Object> actionRefs) {
        this.actionRefs = actionRefs;
    }

    private List<Object> actionRefs;
}
