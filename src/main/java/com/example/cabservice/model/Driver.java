package com.example.cabservice.model;

public class Driver {
    private int userID;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String licenseNumber;
    private String email;
    private String vehicleAssigned;
    private String status;

    public Driver() {
    }

    public Driver(int userID, String username, String password, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }

    public Driver(int userID, String username, String password, String role, String phone, String licenseNumber) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }

    public Driver(int userID, String username, String password, String role, String phone, String licenseNumber, String email, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.status = status;
    }

    public Driver(int userID, String username, String password, String role, String phone, String licenseNumber, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
