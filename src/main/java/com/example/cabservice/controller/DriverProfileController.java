package com.example.cabservice.controller;

import com.example.cabservice.model.Driver;
import com.example.cabservice.model.User;
import com.example.cabservice.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DriverProfileController extends HttpServlet {
    private AuthService userService;

    public void init() {
        userService = new AuthService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserID();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String licenseNumber = request.getParameter("licenseNumber");
        String password = request.getParameter("password");

        Driver driver = userService.getDriverById(userId);
        if (driver != null) {
            driver.setEmail(email);
            driver.setPhone(phone);
            driver.setLicenseNumber(licenseNumber);
            if (password != null && !password.isEmpty()) {
                driver.setPassword(password);
            }
            userService.updateDriver(driver);
            request.setAttribute("driver",userService.getDriverById(userId));
            request.setAttribute("message","Driver updated successfully");
            request.getRequestDispatcher("driver_profile.jsp").forward(request, response);
        } else {
            request.setAttribute("driver",userService.getDriverById(userId));
            request.setAttribute("message","Driver not found");
            request.getRequestDispatcher("driver_profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getUserID();
        req.setAttribute("driver",userService.getDriverById(userId));
        req.getRequestDispatcher("driver_profile.jsp").forward(req, resp);
    }
}