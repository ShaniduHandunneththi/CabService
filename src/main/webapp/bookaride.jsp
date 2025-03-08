<%--
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
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>🚖 Book a Ride</h2>

<form action="BookingController" method="post">
    <input type="hidden" name="action" value="book">

    <label>Pickup Location:</label>
    <input type="text" name="pickupLocation" required><br>

    <label>Drop Location:</label>
    <input type="text" name="dropLocation" required><br>

    <label>Date & Time:</label>
    <input type="datetime-local" name="bookingDate" required><br>

    <input type="submit" value="Confirm Booking">
</form>

<br>
<a href="customer_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
