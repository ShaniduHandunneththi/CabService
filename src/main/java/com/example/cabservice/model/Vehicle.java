package com.example.cabservice.model;

public class Vehicle {
    private int vehicleID;
    private String vehicleNumber;
    private String model;
    private int capacity;
    private String status;

    public Vehicle(int vehicleID, String vehicleNumber, String model, int capacity, String status) {
        this.vehicleID = vehicleID;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.capacity = capacity;
        this.status = status;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}