<%@ page import="com.example.cabservice.model.Booking" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Assigned Rides</title>
    <link rel="stylesheet" href="css\view_assigned_rides.css">
</head>
<body>

<h2>Your Assigned Rides</h2>

<% if (request.getAttribute("message") != null) { %>
<p style="color: green;"><%= request.getAttribute("message") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

<table>
    <tr>
        <th>Booking ID</th>
        <th>Customer ID</th>
        <th>Vehicle ID</th>
        <th>Pickup Location</th>
        <th>Drop Location</th>
        <th>Booking Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <% for (Booking booking : bookings) { %>
    <tr>
        <td><%= booking.getBookingID() %></td>
        <td><%= booking.getCustomerID() %></td>
        <td><%= booking.getVehicleID() %></td>
        <td><%= booking.getPickupLocation() %></td>
        <td><%= booking.getDropLocation() %></td>
        <td><%= booking.getBookingDate() %></td>
        <td><%= booking.getStatus() %></td>
        <td>
            <form action="driver-bookings" method="post">
                <input type="hidden" name="bookingID" value="<%= booking.getBookingID() %>">
                <select name="status">
                    <option value="Pending" <%= "Pending".equals(booking.getStatus()) ? "selected" : "" %>>Pending</option>
                    <option value="Confirmed" <%= "Confirmed".equals(booking.getStatus()) ? "selected" : "" %>>Confirmed</option>
                    <option value="Completed" <%= "Completed".equals(booking.getStatus()) ? "selected" : "" %>>Completed</option>
                    <option value="Cancelled" <%= "Cancelled".equals(booking.getStatus()) ? "selected" : "" %>>Cancelled</option>
                </select>
                <button type="submit">Update</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="driver_dashboard.jsp">Back to Dashboard</a>

</body>
</html>