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
    private VehicleService vehicleService = new VehicleService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int vehicleID = Integer.parseInt(request.getParameter("id"));
            vehicleService.deleteVehicle(vehicleID);
            response.sendRedirect("managevehicles.jsp");
        } else if("list".equals(action)) {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            request.setAttribute("vehicleList", vehicles);
            request.getRequestDispatcher("managevehicles.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action.equals("add")) {
            addVehicle(request, response);
        }
        else if(action.equals("update")) {
            updateVehicleStatus(request, response);
        }
    }

    private void updateVehicleStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
        String status = request.getParameter("status");

        vehicleService.updateVehicleStatus(vehicleID, status);
        response.sendRedirect("vehicle?action=list&success=status_updated");
    }
    private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vehicleNumber = request.getParameter("vehicleNumber");
        String model = request.getParameter("model");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String status = request.getParameter("status");

        Vehicle vehicle = new Vehicle(vehicleNumber, model, capacity, status);
        vehicleService.addVehicle(vehicle);
        response.sendRedirect("vehicle?action=list&success=added");
    }
}
