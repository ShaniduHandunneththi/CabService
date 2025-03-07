package com.example.cabservice.controller;

import com.example.cabservice.model.Booking;
import com.example.cabservice.model.User;
import com.example.cabservice.service.BookingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingService bookingService;

    public void init() {
        bookingService = new BookingService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "delete":
                deleteBooking(request, response);
                break;
            case "cancel":
                if ("cancel".equals(action)) {
                    int bookingId = Integer.parseInt(request.getParameter("id"));
                    bookingService.cancelBooking(bookingId);
                    response.sendRedirect("managebookings.jsp?success=cancelled");
                }
            case "customer_view":
                List<Booking> bookings = bookingService.getBookingsByCustomer(user.getUserID());
                request.setAttribute("bookings", bookings);
                request.getRequestDispatcher("managebookings.jsp").forward(request, response);
                break;
            default:
                listBookings(request, response);
                break;
        }
    }

    private void listBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBookings();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("manage_bookings.jsp").forward(request, response);
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookingID = Integer.parseInt(request.getParameter("id"));
        bookingService.deleteBooking(bookingID);
        response.sendRedirect("BookingController");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int customerID = (int) session.getAttribute("userID");

        if ("book".equals(action)) {
            String pickupLocation = request.getParameter("pickupLocation");
            String dropLocation = request.getParameter("dropLocation");
            String dateTimeStr = request.getParameter("bookingDate");

            LocalDateTime bookingDate = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

            Booking booking = new Booking(customerID, pickupLocation, dropLocation, "Pending");
            bookingService.bookRide(booking);
            response.sendRedirect("customer_dashboard.jsp");

        }
    }

}


