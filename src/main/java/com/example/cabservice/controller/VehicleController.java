package com.example.cabservice.controller;

import com.example.cabservice.dao.VehicleDAO;
import com.example.cabservice.model.Vehicle;
import com.example.cabservice.service.VehicleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class VehicleController extends HttpServlet {
    private VehicleService vehicleService;

    @Override
    public void init() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
            VehicleDAO vehicleDAO = new VehicleDAO(connection);
            vehicleService = new VehicleService(vehicleDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int vehicleID = Integer.parseInt(request.getParameter("id"));
            vehicleService.deleteVehicle(vehicleID);
            response.sendRedirect("managevehicles.jsp");
        } else {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            request.setAttribute("vehicleList", vehicles);
            request.getRequestDispatcher("managevehicles.jsp").forward(request, response);
        }
    }
}
