package com.example.listviews_recyclerview_missionandroid123.Model;

public class Contact {
    private int id;
    private String name;
    private String emailId;
    private String mobileNumber;


    public Contact() {}

    public Contact(int id, String name, String emailId, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
