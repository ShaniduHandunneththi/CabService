package com.example.cabservice.controller;

import com.example.cabservice.model.Booking;
import com.example.cabservice.model.User;
import com.example.cabservice.model.Vehicle;
import com.example.cabservice.service.BookingService;
import com.example.cabservice.service.DriverService;
import com.example.cabservice.service.VehicleService;
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
    private VehicleService vehicleService = new VehicleService();
    private DriverService driverService = new DriverService();

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
            case "add":
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                request.setAttribute("vehicles", vehicles);
                request.setAttribute("drivers", driverService.getAllDrivers());
                request.getRequestDispatcher("bookaride.jsp").forward(request, response);
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
        HttpSession session = request.getSession(false); // Do NOT create a new session

        // Debugging: Print session attributes
        System.out.println("Session userID: " + session.getAttribute("userID"));
        System.out.println("Session username: " + session.getAttribute("username"));

        if (session == null || session.getAttribute("userID") == null) {
            response.sendRedirect("login.jsp?error=session_expired");
            return;
        }

        int customerID = (Integer) session.getAttribute("userID"); // Retrieve customer ID

        if ("book".equals(action)) {
            String pickupLocation = request.getParameter("pickupLocation");
            String dropLocation = request.getParameter("dropLocation");
            String dateTimeStr = request.getParameter("bookingDate");
            int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
            int driverId = Integer.parseInt(request.getParameter("driverID"));
            double distance = Double.parseDouble(request.getParameter("distance"));

            try {
                LocalDateTime bookingDate = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
                Booking booking = new Booking(customerID, pickupLocation, dropLocation,vehicleID,distance, "Pending");
                booking.setDriverID(driverId);


                bookingService.bookRide(booking);
                response.sendRedirect("customer_dashboard.jsp?success=booked");
            } catch (Exception e) {
                response.sendRedirect("bookaride.jsp?error=invalid_date");
            }
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            String status = request.getParameter("status");

            boolean updated = bookingService.updateBookingStatus(bookingID, status);

            if (updated) {
                request.setAttribute("message", "Booking status updated successfully.");
            } else {
                request.setAttribute("error", "Failed to update booking status.");
            }

            request.getRequestDispatcher("view_assigned_rides.jsp").forward(request, response);
        }
    }
}




