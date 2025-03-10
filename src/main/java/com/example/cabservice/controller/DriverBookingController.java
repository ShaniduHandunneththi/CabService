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

public class DriverBookingController extends HttpServlet {

    private BookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Booking> bookings = bookingService.getBookingsByDriver(user.getUserID());
        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("view_assigned_rides.jsp").forward(req, resp);
    }
}
