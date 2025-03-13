<%@ page import="com.example.cabservice.model.Booking" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 10-03-2025
  Time: 02:22 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Booking> rideHistory = (List<Booking>) request.getAttribute("rideHistory");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ride History</title>
    <link rel="stylesheet" href="css\ride_history.css">
</head>
<body>

<h2>Your Ride History</h2>

<table>
    <tr>
        <th>Booking ID</th>
        <th>Vehicle ID</th>
        <th>Pickup Location</th>
        <th>Drop Location</th>
        <th>Booking Date</th>
        <th>Status</th>
    </tr>
    <% if (rideHistory != null && !rideHistory.isEmpty()) { %>
    <% for (Booking booking : rideHistory) { %>
    <tr>
        <td><%= booking.getBookingID() %></td>
        <td><%= booking.getVehicleID() %></td>
        <td><%= booking.getPickupLocation() %></td>
        <td><%= booking.getDropLocation() %></td>
        <td><%= booking.getBookingDate() %></td>
        <td><%= booking.getStatus() %></td>
    </tr>
    <% } %>
    <% } else { %>
    <tr><td colspan="6">No ride history available.</td></tr>
    <% } %>
</table>

<a href="driver_dashboard.jsp">Back to Dashboard</a>

</body>
</html>