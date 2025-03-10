package com.example.cabservice.dao;

import com.example.cabservice.model.Booking;
import com.example.cabservice.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingID(rs.getInt("BookingID"));
                booking.setCustomerID(rs.getInt("CustomerID"));
                booking.setDriverID(rs.getInt("DriverID"));
                booking.setVehicleID(rs.getInt("VehicleID"));
                booking.setPickupLocation(rs.getString("PickupLocation"));
                booking.setDropLocation(rs.getString("DropLocation"));
                booking.setBookingDate(rs.getTimestamp("BookingDate"));
                booking.setStatus(rs.getString("Status"));
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void deleteBooking(int bookingID) {
        String sql = "DELETE FROM bookings WHERE BookingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (CustomerID, PickupLocation, DropLocation, BookingDate, Status) VALUES (?, ?, ?, now(), ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, booking.getCustomerID());
            ps.setString(2, booking.getPickupLocation());
            ps.setString(3, booking.getDropLocation());
            ps.setString(4, booking.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Booking> getBookingsByCustomer(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE CustomerID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingID(rs.getInt("BookingID"));
                booking.setCustomerID(rs.getInt("CustomerID"));
                booking.setDriverID(rs.getInt("DriverID"));
                booking.setVehicleID(rs.getInt("VehicleID"));
                booking.setPickupLocation(rs.getString("PickupLocation"));
                booking.setDropLocation(rs.getString("DropLocation"));
                booking.setBookingDate(rs.getTimestamp("BookingDate"));
                booking.setStatus(rs.getString("Status"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void updateBookingStatus(int bookingId, String status) {
        String sql = "UPDATE bookings SET Status = ? WHERE BookingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Booking> getBookingsByDriver(int driverId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE DriverID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, driverId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("BookingID"),
                        rs.getInt("CustomerID"),
                        rs.getInt("DriverID"),
                        rs.getInt("VehicleID"),
                        rs.getString("PickupLocation"),
                        rs.getString("DropLocation"),
                        rs.getDate("BookingDate"),
                        rs.getString("Status")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}

