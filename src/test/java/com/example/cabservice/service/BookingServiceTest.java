package com.example.cabservice.service;

import com.example.cabservice.dao.BookingDAO;
import com.example.cabservice.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {



    @Test
    void getAllBookings() {

        // Initialize the actual DAO and the service
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService();

        // Call the service method to fetch all bookings
        List<Booking> bookings = bookingService.getAllBookings();

        // Verify the result
        assertNotNull((Object) "Expected bookings list to be not null", bookings.toString());
        assertTrue(bookings.size() > 0, "Expected at least one booking");
    }

    @Test
    void getBookingsByCustomer() {
        // Initialize the actual DAO and service
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService();

        // Customer ID 42 exists in the database
        int customerId = 42;

        // Retrieve bookings for customer ID 42
        List<Booking> bookings = bookingService.getBookingsByCustomer(customerId);

        // Assertions
        assertNotNull(bookings, "Expected bookings list to be not null");
        assertFalse(bookings.isEmpty(), "Expected at least one booking for customer ID " + customerId);

        // Check that all retrieved bookings belong to the customer ID 42
        for (Booking booking : bookings) {
            Assertions.assertEquals(customerId, booking.getCustomerID(), "Booking does not belong to customer ID " + customerId);
        }

        // Check one expected booking
        boolean foundBooking = bookings.stream()
                .anyMatch(b -> b.getBookingID() == 513 && "piliyandala".equals(b.getPickupLocation()) && "panadura".equals(b.getDropLocation()));

        assertTrue(foundBooking, "Expected booking with ID 513 for customer ID 42 not found");
    }

    private void assertEquals(String s, int i, int customerID) {
    }


    @Test
    void getBookingsByDriver() {
        // Initialize the actual DAO and service
        BookingDAO bookingDAO = new BookingDAO();
        BookingService bookingService = new BookingService();

        // Driver ID 201 exists in the database
        int driverId = 201;

        // Retrieve bookings for driver ID 201
        List<Booking> bookings = bookingService.getBookingsByDriver(driverId);

        // Assertions
        assertNotNull(bookings, "Expected bookings list to be not null");
        assertFalse(bookings.isEmpty(), "Expected at least one booking for driver ID " + driverId);

        // Check that all retrieved bookings belong to the driver ID 201
        for (Booking booking : bookings) {
            Assertions.assertEquals(driverId, booking.getDriverID(), "Booking does not belong to driver ID " + driverId);
        }

        // Check one expected booking
        boolean foundBooking = bookings.stream()
                .anyMatch(b -> b.getBookingID() == 513 && "piliyandala".equals(b.getPickupLocation()) && "panadura".equals(b.getDropLocation()));

        assertTrue(foundBooking, "Expected booking with ID 513 for driver ID 201 not found");

    }
}