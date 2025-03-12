package com.example.cabservice.dao;

import com.example.cabservice.model.Vehicle;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("VehicleID"),
                        rs.getString("VehicleNumber"),
                        rs.getString("Model"),
                        rs.getInt("Capacity"),
                        rs.getString("Status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public void updateVehicleStatus(int vehicleID, String status) {
        String sql = "UPDATE vehicles SET Status = ? WHERE VehicleID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, status);
            pstmt.setInt(2, vehicleID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int vehicleID) {
        String sql = "DELETE FROM vehicles WHERE VehicleID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, vehicleID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (VehicleNumber, Model, Capacity, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getVehicleNumber());
            pstmt.setString(2, vehicle.getModel());
            pstmt.setInt(3, vehicle.getCapacity());
            pstmt.setString(4, vehicle.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}