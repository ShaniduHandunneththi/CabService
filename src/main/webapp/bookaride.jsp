<%@ page import="com.example.cabservice.model.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cabservice.model.Driver" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 05-03-2025
  Time: 08:36 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book a Ride</title>
    <link rel="stylesheet" href="css\bookaride.css">
</head>
<body>

<h2>🚖 Book a Ride</h2>

<form action="BookingController" method="post">
    <input type="hidden" name="action" value="book">

    <!-- Pickup Location -->
    <label for="pickup">Pickup Location:</label>
    <input type="text" id="pickup" name="pickupLocation" required>

    <!-- Drop Location -->
    <label for="drop">Drop Location:</label>
    <input type="text" id="drop" name="dropLocation" required>

    <!-- Select Vehicle -->
    <label for="vehicle">Select Vehicle:</label>
    <select id="vehicle" name="vehicleID" required>
        <%
            List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
            if (vehicles != null && !vehicles.isEmpty()) {
                for (Vehicle v : vehicles) {
        %>
        <option value="<%= v.getVehicleID() %>">
            <%= v.getModel() %> - <%= v.getVehicleNumber() %> - Capacity: <%= v.getCapacity() %>
        </option>
        <%
            }
        } else {
        %>
        <option value="">No available vehicles</option>
        <% } %>
    </select>

    <!-- Select Driver -->
    <label for="driver">Select Driver:</label>
    <select id="driver" name="driverID" required>
        <%
            List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
            if (drivers != null && !drivers.isEmpty()) {
                for (Driver d : drivers) {
        %>
        <option value="<%= d.getUserID() %>">
            <%= d.getUsername() %> - <%= d.getEmail() %>
        </option>
        <%
            }
        } else {
        %>
        <option value="">No available Drivers</option>
        <% } %>
    </select>

    <!-- Booking Date & Time -->
    <label for="bookingDate">📅 Date & Time:</label>
    <input type="datetime-local" id="bookingDate" name="bookingDate" required>

    <!-- Distance Input -->
    <label for="distance">📏 Distance (km):</label>
    <input type="number" id="distance" name="distance" step="0.1" required>

    <!-- Submit Button -->
    <input type="submit" value="Confirm Booking">
</form>

<br>
<a href="customer_dashboard.jsp">Back to Dashboard</a>

</body>
</html>