package com.example.cabservice.service;

import com.example.cabservice.dao.BookingDAO;
import com.example.cabservice.model.Booking;

import java.util.List;

public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    public void deleteBooking(int bookingID) {
        bookingDAO.deleteBooking(bookingID);

    }

    public boolean updateBookingStatus(int bookingID, String status) {
        return bookingDAO.updateStatus(bookingID, status);
    }

    public void bookRide(Booking booking) {
      double fare = booking.getDistance()* 2.5;
      booking.setFare(fare);
        bookingDAO.addBooking(booking);
    }
    public List<Booking> getBookingsByCustomer(int customerId) {
        return bookingDAO.getBookingsByCustomer(customerId);
    }

    public void cancelBooking(int bookingId) {
        bookingDAO.updateBookingStatus(bookingId, "Cancelled");
    }
    public List<Booking> getBookingsByDriver(int driverId) {
        return bookingDAO.getBookingsByDriver(driverId);
    }
}



