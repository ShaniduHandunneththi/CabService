package com.example.cabservice.service;

import com.example.cabservice.model.Driver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceTest {


    @Test
    public void testGetDriverByID() {
        DriverService driverService = new DriverService();
        Driver driver = driverService.getDriverByID(1);
        assertNull(driver);
    }

    @Test
    public void testDeleteDriver() {
        DriverService driverService = new DriverService();
        boolean result = driverService.deleteDriver(1);
        assertFalse(result); // Since no actual DAO implementation
    }

    @Test
    public void testRegisterDriver() {
        DriverService driverService = new DriverService();
        Driver driver = new Driver(1, "John Doe");
        boolean result = driverService.registerDriver(driver);
        assertFalse(result); // Since no actual DAO implementation
    }

    @Test
    public void testChangeDriverStatus() {
        DriverService driverService = new DriverService();
        boolean result = driverService.changeDriverStatus(1, "Active");
        assertFalse(result); // Since no actual DAO implementation


    }
}