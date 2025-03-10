package com.example.cabservice.dao;

import com.example.cabservice.model.Customer;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO() {
        this.connection = DBConnection.getConnection();
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT UserID, Username, Role FROM users WHERE Role = 'Customer'";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        null, // Password not retrieved for security
                        rs.getString("Role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public boolean deleteCustomer(int userID) {
        String query = "DELETE FROM users WHERE UserID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}