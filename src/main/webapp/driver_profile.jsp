<%@ page import="com.example.cabservice.model.Driver" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 10-03-2025
  Time: 06:49 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Driver driver = (Driver) request.getAttribute("driver");
  String message = (String) request.getAttribute("message");
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Driver Profile</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Driver Profile</h2>

<p><%= message%></p>
<form action="driver-profile" method="post">
  <input type="hidden" name="userId" value="<%= driver.getUserID() %>">

  <label>Username:</label>
  <input type="text" name="username" value="<%= driver.getUsername() %>" readonly><br>

  <label>Email:</label>
  <input type="email" name="email" value="<%= driver.getEmail() %>" required><br>

  <label>Phone:</label>
  <input type="text" name="phone" value="<%= driver.getPhone() %>" required><br>

  <label>License Number:</label>
  <input type="text" name="licenseNumber" value="<%= driver.getLicenseNumber() %>" required><br>

  <label>Password:</label>
  <input type="password" name="password" value=""><br>

  <input type="submit" value="Update Profile">
</form>

<a href="driver_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
