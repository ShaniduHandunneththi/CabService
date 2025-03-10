<%@ page import="com.example.cabservice.model.Vehicle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 04-03-2025
  Time: 06:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Vehicles</title>
    <link rel="stylesheet" href="styles.css"> <!-- Include CSS file -->
</head>
<body>
<h2>Manage Vehicles</h2>

<table border="1">
    <tr>
        <th>Vehicle ID</th>
        <th>Vehicle Number</th>
        <th>Model</th>
        <th>Capacity</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

    <%
        List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicleList");
        if (vehicles != null) {
            for (Vehicle vehicle : vehicles) {
    %>
    <tr>
        <td><%= vehicle.getVehicleID() %></td>
        <td><%= vehicle.getVehicleNumber() %></td>
        <td><%= vehicle.getModel() %></td>
        <td><%= vehicle.getCapacity() %></td>
        <td><%= vehicle.getStatus() %></td>
        <td>
            <a href="VehicleController?action=edit&id=<%= vehicle.getVehicleID() %>">Edit</a> |
            <a href="VehicleController?action=delete&id=<%= vehicle.getVehicleID() %>"
               onclick="return confirm('Are you sure you want to delete this vehicle?');">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<a href="add_vehicle.jsp">Add New Vehicle</a>
</body>
</html>
