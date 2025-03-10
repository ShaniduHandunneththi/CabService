<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 07:11 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Vehicle</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Vehicle Registration</h2>

<% if (errorMessage != null) { %>
<p style="color: red;"><%= errorMessage %></p>
<% } %>

<% if (successMessage != null) { %>
<p style="color: green;"><%= successMessage %></p>
<% } %>

<form action="vehicle" method="post">
    <input type="hidden" name="action" value="register">

    <label>Vehicle Number:</label>
    <input type="text" name="vehicleNumber" required>

    <label>Vehicle Type:</label>
    <input type="text" name="vehicleType" required>

    <label>Model:</label>
    <input type="text" name="model" required>

    <label>Year:</label>
    <input type="number" name="year" required>

    <label>Driver ID:</label>
    <input type="number" name="driverID" required>

    <button type="submit">Register Vehicle</button>
</form>
</body>
</html>