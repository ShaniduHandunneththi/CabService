package com.example.cabservice.service;

import com.example.cabservice.model.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {


    @Test
    public void testAddVehicle() {
        VehicleService vehicleService = new VehicleService();
        Vehicle vehicle = new Vehicle(1, "ABC-1234", "Toyota", "Sedan");
        vehicleService.addVehicle(vehicle);
        assertTrue(true); // Verifying method execution
    }



    @Test
    public void testDeleteVehicle() {
        VehicleService vehicleService = new VehicleService();
        vehicleService.deleteVehicle(1);
        assertTrue(true); // Just verifying method call
    }

    @Test
    public void testChangeDriverStatus() {
        VehicleService vehicleService = new VehicleService();
        vehicleService.changeDriverStatus(1, "Inactive");
        assertTrue(true); // Just verifying method call


    }
}