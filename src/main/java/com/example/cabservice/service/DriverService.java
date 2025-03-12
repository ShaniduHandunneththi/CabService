package com.example.cabservice.service;

import com.example.cabservice.dao.DriverDAO;
import com.example.cabservice.model.Driver;
import com.example.cabservice.utils.DBConnection;

import java.sql.Connection;
import java.util.List;

public class DriverService {
    private DriverDAO driverDAO = new DriverDAO();

    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }

    public Driver getDriverByID(int driverID) {
        return driverDAO.getDriverByID(driverID);
    }


    public boolean deleteDriver(int userID) {
        return driverDAO.deleteDriver(userID);
    }
    public boolean registerDriver(Driver driver) {
        return driverDAO.registerDriver(driver);
    }



    public boolean changeDriverStatus(int driverID, String status) {
        return driverDAO.updateDriverStatus(driverID, status);
    }


}


