<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 09-03-2025
  Time: 07:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Driver Registration</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Register as a Driver</h2>
<form action="DriverController" method="post">
    <input type="hidden" name="action" value="register">
    <label>Username:</label>
    <input type="text" name="username" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>Phone:</label>
    <input type="text" name="phone" required><br>
    <label>License Number:</label>
    <input type="text" name="licenseNumber" required><br>
    <button type="submit">Register</button>
</form>
</body>
</html>
