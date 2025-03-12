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
            <form action="vehicle" method="post">

                <input type="hidden" name="vehicleID" value="<%= vehicle.getVehicleID() %>">

                <select name="status">
                    <option value="Available" <% if("Available".equals(vehicle.getStatus())) { %>selected<% } %>>Available</option>
                    <option value="In Service" <% if("In Service".equals(vehicle.getStatus())) { %>selected<% } %>>In Service</option>
                    <option value="Booked" <% if("Booked".equals(vehicle.getStatus())) { %>selected<% } %>>Booked</option>
                </select>

                <button type="submit">Update</button>
            </form>

        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<a href="admin_dashboard.jsp">Back to Dashboard</a>

<a href="add_vehicle.jsp">Add New Vehicle</a>
</body>
</html>
