package com.example.cabservice.dao;

import com.example.cabservice.model.Billing;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;

public class BillingDAO {

    public boolean generateBill(Billing billing) {
        String sql = "INSERT INTO Billing (BookingID, CustomerID, TotalFare, Tax, Discount, FinalAmount, PaymentStatus, PaymentMethod) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, billing.getBookingID());
            stmt.setInt(2, billing.getCustomerID());
            stmt.setDouble(3, billing.getTotalFare());
            stmt.setDouble(4, billing.getTax());
            stmt.setDouble(5, billing.getDiscount());
            stmt.setDouble(6, billing.getFinalAmount());
            stmt.setString(7, billing.getPaymentStatus());
            stmt.setString(8, billing.getPaymentMethod());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Billing getBillByBookingID(int bookingID) {
        String sql = "SELECT * FROM Billing WHERE BookingID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Billing billing = new Billing();
                billing.setBillID(rs.getInt("BillID"));
                billing.setBookingID(rs.getInt("BookingID"));
                billing.setCustomerID(rs.getInt("CustomerID"));
                billing.setTotalFare(rs.getDouble("TotalFare"));
                billing.setTax(rs.getDouble("Tax"));
                billing.setDiscount(rs.getDouble("Discount"));
                billing.setFinalAmount(rs.getDouble("FinalAmount"));
                billing.setPaymentStatus(rs.getString("PaymentStatus"));
                billing.setPaymentMethod(rs.getString("PaymentMethod"));
                billing.setBillingDate(rs.getTimestamp("BillingDate"));
                return billing;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}