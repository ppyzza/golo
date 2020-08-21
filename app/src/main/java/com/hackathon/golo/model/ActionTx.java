package com.hackathon.golo.model;

public class ActionTx {
    private Object type;
    private String attribute;
    private Object op;
    private String value;
    private String valueType;
    private Object note;
    private boolean resolveAction;

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Object getOp() {
        return op;
    }

    public void setOp(Object op) {
        this.op = op;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public boolean isResolveAction() {
        return resolveAction;
    }

    public void setResolveAction(boolean resolveAction) {
        this.resolveAction = resolveAction;
    }
}
