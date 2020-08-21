package com.hackathon.golo.model;

import java.util.Date;
import java.util.List;

public class Then {
    private String action;
    private boolean internalAction;
    private String actionRef;
    private List<Datum> data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isInternalAction() {
        return internalAction;
    }

    public void setInternalAction(boolean internalAction) {
        this.internalAction = internalAction;
    }

    public String getActionRef() {
        return actionRef;
    }

    public void setActionRef(String actionRef) {
        this.actionRef = actionRef;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
}
