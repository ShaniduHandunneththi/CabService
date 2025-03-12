package com.example.cabservice.dao;

import com.example.cabservice.model.Driver;
import com.example.cabservice.model.Vehicle;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    public Driver getDriverByID(int driverID) {
        String sql = "SELECT * FROM users WHERE UserID = ? AND Role = 'Driver'";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, driverID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Driver(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Role"),
                        rs.getString("Phone"),
                        rs.getString("LicenseNumber")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE Role = 'Driver'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                drivers.add(new Driver(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Role"),
                        rs.getString("Phone"),
                        rs.getString("LicenseNumber"),
                        rs.getString("Email"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public boolean deleteDriver(int userID) {
        String sql = "DELETE FROM users WHERE UserID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerDriver(Driver driver) {
        String sql = "INSERT INTO users (Username, Password, Role, Email, Phone, licenseNumber, status, CreatedAt) VALUES (?, ?, ?, ?, ?, ?,?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, driver.getUsername());
            stmt.setString(2, driver.getPassword());
            stmt.setString(3, "Driver"); // Default role
            stmt.setString(4, driver.getEmail());
            stmt.setString(5, driver.getPhone());
            stmt.setString(6, driver.getLicenseNumber());
            stmt.setString(7, "Active");

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDriverStatus(int driverID, String status) {
        String sql = "UPDATE users SET status = ? WHERE UserID = ? AND Role = 'Driver'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, driverID);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Returns true if update successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    }
