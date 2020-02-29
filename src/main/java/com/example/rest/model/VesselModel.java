package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

@Entity
public class VesselModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private Date date;
    private double latitude;
    private double longitude;
    private double speed;
    @UpdateTimestamp
    private Date receiveDate;

    @SuppressWarnings("unchecked")
    @JsonProperty("Position")
    private void unpackNested(Map<String,Object> Position) {
        this.date = (Date)Position.get("date");
        this.latitude = (double)Position.get("latitude");
        this.longitude = (double)Position.get("longitude");
        this.speed = (double)Position.get("speed");
    }

    //getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

