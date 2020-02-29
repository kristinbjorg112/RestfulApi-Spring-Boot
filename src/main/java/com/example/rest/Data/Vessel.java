package com.example.rest.Data;

import java.util.Date;

public class Vessel {

    private Long id;
    private String name;
    private String country;
    private Date date;
    private Double latitude;
    private Double longitude;
    private double speed;
    private Date receiveDate;

    //Getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() { return latitude; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }

    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public double getSpeed() { return speed; }

    public void setSpeed(double speed) { this.speed = speed; }

    public Date getReceiveDate() { return receiveDate; }

    public void setReceiveDate(Date receiveDate) { this.receiveDate = receiveDate; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

