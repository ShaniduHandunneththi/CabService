package com.example.cabservice.service;

import com.example.cabservice.dao.VehicleDAO;
import com.example.cabservice.model.Vehicle;

import java.util.List;

public class VehicleService {
    private VehicleDAO vehicleDAO;

    public VehicleService(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }

    public void deleteVehicle(int vehicleID) {
        vehicleDAO.deleteVehicle(vehicleID);
    }
}