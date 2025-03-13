<%@ page import="com.example.cabservice.service.BookingService" %>
<%@ page import="com.example.cabservice.model.Booking" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 03:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookingService bookingService = new BookingService();
    List<Booking> bookings = bookingService.getAllBookings();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Bookings</title>
    <link rel="stylesheet" href="css\booking.css">
</head>
<body>
<h2>View Bookings</h2>

<table>
    <tr>
        <th>Booking ID</th>
        <th>Customer ID</th>
        <th>Driver ID</th>
        <th>Vehicle ID</th>
        <th>Pickup Location</th>
        <th>Drop Location</th>
        <th>Booking Date</th>
        <th>Status</th>
    </tr>
    <% for (Booking booking : bookings) { %>
    <tr>
        <td><%= booking.getBookingID() %></td>
        <td><%= booking.getCustomerID() %></td>
        <td><%= booking.getDriverID() %></td>
        <td><%= booking.getVehicleID() %></td>
        <td><%= booking.getPickupLocation() %></td>
        <td><%= booking.getDropLocation() %></td>
        <td><%= booking.getBookingDate() %></td>
        <td><%= booking.getStatus() %></td>
    </tr>
    <% } %>
</table>

<a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>