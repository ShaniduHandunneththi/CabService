package com.example.cabservice.dao;

import com.example.cabservice.model.Customer;
import com.example.cabservice.model.User;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String SELECT_ALL_CUSTOMERS = "SELECT UserID, Username, Email, Phone, Status FROM users WHERE Role = 'Customer'";
    private static final String UPDATE_CUSTOMER_STATUS = "UPDATE users SET status = ? WHERE UserID = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM users WHERE UserID = ?";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM users WHERE UserID = ?";

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_CUSTOMERS)){

             try(ResultSet rs = pstmt.executeQuery()){

                while (rs.next()) {
                    Customer user = new Customer();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUsername(rs.getString("Username"));
                    user.setEmail(rs.getString("Email"));
                    user.setPhone(rs.getString("Phone"));
                    user.setStatus(rs.getString("Status"));

                    customers.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void updateCustomerStatus(int userID, String status) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_CUSTOMER_STATUS)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int userID) {
        Customer user = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_CUSTOMER_BY_ID)) {

            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new Customer();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setPhone(rs.getString("Phone"));
                user.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}