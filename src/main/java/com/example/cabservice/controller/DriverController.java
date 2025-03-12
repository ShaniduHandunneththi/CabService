package com.example.cabservice.controller;

import com.example.cabservice.dao.DriverDAO;
import com.example.cabservice.model.Driver;
import com.example.cabservice.service.DriverService;
import com.example.cabservice.utils.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;


public class DriverController extends HttpServlet {
    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        driverService = new DriverService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Driver> drivers = driverService.getAllDrivers();
        request.setAttribute("driverList", drivers);
        request.getRequestDispatcher("managedrivers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


        if ("delete".equals(action)) {
            int userID = Integer.parseInt(request.getParameter("driverID"));
            driverService.deleteDriver(userID);
        }
        else if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String licenseNumber = request.getParameter("licenseNumber");

            Driver driver = new Driver(0, username, password, "Driver", phone, licenseNumber, email);
            boolean isRegistered = driverService.registerDriver(driver);

            if (isRegistered) {
                response.sendRedirect("login.jsp?success=Driver registered successfully!");
            } else {
                response.sendRedirect("register_driver.jsp?error=Registration failed!");
            }
        } else if ("updateStatus".equals(action)) {
            int driverID = Integer.parseInt(request.getParameter("driverID"));
            String status = request.getParameter("status");

            boolean updated = driverService.changeDriverStatus(driverID, status);
            if (updated) {
                response.sendRedirect("driver?action=list&success=status_updated");
            } else {
                response.sendRedirect("driver?action=list&error=update_failed");
            }
        }



    }

}