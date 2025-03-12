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
    <link rel="stylesheet" href="css\register_driver.css">
</head>
<body>
<div class="registration-container">
    <h2>Register as a Driver</h2>
    <form action="driver" method="post">
        <input type="hidden" name="action" value="register">

        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Phone:</label>
        <input type="text" name="phone" required>

        <label>License Number:</label>
        <input type="text" name="licenseNumber" required>

        <button type="submit">Register</button>
    </form>

    <a href="login.jsp">Back to Dashboard</a>
</div>
</body>
</html>
