package com.example.cabservice.model;

import java.util.Date;

public class Booking {
    private int bookingID;
    private int customerID;
    private int driverID;
    private int vehicleID;
    private String pickupLocation;
    private String dropLocation;
    private Date bookingDate;
    private String status;

    public Booking() {}

    public Booking(int bookingID, int customerID, int driverID, int vehicleID, String pickupLocation, String dropLocation, Date bookingDate, String status) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.driverID = driverID;
        this.vehicleID = vehicleID;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.bookingDate = bookingDate;
        this.status = status;
    }
    public Booking(int customerID, String pickupLocation, String dropLocation, String status) {
        this.customerID = customerID;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = status;
    }

    // Getters and Setters
    public int getBookingID() { return bookingID; }
    public void setBookingID(int bookingID) { this.bookingID = bookingID; }

    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public int getDriverID() { return driverID; }
    public void setDriverID(int driverID) { this.driverID = driverID; }

    public int getVehicleID() { return vehicleID; }
    public void setVehicleID(int vehicleID) { this.vehicleID = vehicleID; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
