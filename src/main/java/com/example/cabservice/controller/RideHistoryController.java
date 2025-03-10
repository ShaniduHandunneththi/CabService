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
import java.util.List;

public class RideHistoryController extends HttpServlet {
    private BookingService bookingService;

    public void init() {
        bookingService = new BookingService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String role = (String) session.getAttribute("role");

        List<Booking> rideHistory;
        if ("Customer".equals(role)) {
            rideHistory = bookingService.getBookingsByCustomer(user.getUserID());
        } else if ("Driver".equals(role)) {
            rideHistory = bookingService.getBookingsByDriver(user.getUserID());
        } else {
            response.sendRedirect("login.jsp?error=Please log in first.");
            return;
        }

        request.setAttribute("rideHistory", rideHistory);
        request.getRequestDispatcher("ride_history.jsp").forward(request, response);
    }
}