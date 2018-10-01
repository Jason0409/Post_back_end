package com.project.demo1.entity;

public class Parcel {

    private Integer parcelId;
    private String parcelTrackId;
    private String assignerEmail;
    private String agentEmail;
    private String courierEmail;
    private String receiverName;
    private String receiverPhone;
    private String destination;
    private String parcelTime;
    private String parcelStatus;
    private String parcelVcode;
    private String parcelWay;

    public String getParcelWay() {
        return parcelWay;
    }

    public void setParcelWay(String parcelWay) {
        this.parcelWay = parcelWay;
    }

    public String getParcelTime() {
        return parcelTime;
    }

    public void setParcelTime(String parcelTime) {
        this.parcelTime = parcelTime;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public String getParcelVcode() {
        return parcelVcode;
    }

    public void setParcelVcode(String parcelVcode) {
        this.parcelVcode = parcelVcode;
    }

    public Integer getParcelId() {
        return parcelId;
    }

    public void setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelTrackId() {
        return parcelTrackId;
    }

    public void setParcelTrackId(String parcelTrackId) {
        this.parcelTrackId = parcelTrackId;
    }

    public String getAssignerEmail() {
        return assignerEmail;
    }

    public void setAssignerEmail(String assignerEmail) {
        this.assignerEmail = assignerEmail;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getCourierEmail() {
        return courierEmail;
    }

    public void setCourierEmail(String courierEmail) {
        this.courierEmail = courierEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }



}
