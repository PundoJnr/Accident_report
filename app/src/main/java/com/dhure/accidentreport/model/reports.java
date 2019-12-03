package com.dhure.accidentreport.model;

public class reports {
    String hurt, vehicle, own, date, time, location;

    public reports() {
    }

    public reports(String hurt, String vehicle, String own, String date, String time, String location) {
        this.hurt = hurt;
        this.vehicle = vehicle;
        this.own = own;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getHurt() {
        return hurt;
    }

    public void setHurt(String hurt) {
        this.hurt = hurt;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
