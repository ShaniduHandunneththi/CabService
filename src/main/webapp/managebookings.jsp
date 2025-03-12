<%@ page import="com.example.cabservice.model.Booking" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 06-03-2025
  Time: 06:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<html lang="en">
<head>
    <title>Manage Bookings</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>My Bookings</h2>

<table border="1">
    <tr>
        <th>Booking ID</th>
        <th>Pickup Location</th>
        <th>Destination</th>
        <th>Date</th>
        <th>Driver</th>
        <th>Status</th>

    </tr>

    <% if(bookings != null){
        for (Booking booking : bookings) { %>
    <tr>
        <td><%= booking.getBookingID() %></td>
        <td><%= booking.getPickupLocation() %></td>
        <td><%= booking.getDropLocation() %></td>
        <td><%= booking.getBookingDate() %></td>
        <td><%= booking.getDriverID() %></td>
        <td><%= booking.getStatus() %></td>

    </tr>
    <% }} %>
</table>

<a href="customer_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
