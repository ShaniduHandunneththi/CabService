package com.example.cabservice.service;

import com.example.cabservice.dao.VehicleDAO;
import com.example.cabservice.model.Vehicle;

import java.util.List;

public class VehicleService {
    private VehicleDAO vehicleDAO = new VehicleDAO();


    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
    public void updateVehicleStatus(int vehicleID, String status) {
        vehicleDAO.updateVehicleStatus(vehicleID, status);
    }
    public void deleteVehicle(int vehicleID) {
        vehicleDAO.deleteVehicle(vehicleID);
    }
    public void addVehicle(Vehicle vehicle) {
        vehicleDAO.addVehicle(vehicle);
    }
}