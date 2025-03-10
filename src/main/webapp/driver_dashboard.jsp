<%@ page import="com.example.cabservice.model.User" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 09-03-2025
  Time: 05:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");

%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Welcome, <%= user.getUsername() %> (Driver)</h2>

<ul>
    <li><a href="driver-bookings">View Assigned Rides</a></li>
    <li><a href="ride-history">Ride History & Earnings</a></li>
    <li><a href="driver-profile">Profile & Account Management</a></li>
    <li>
        <form action="admin" method="post">
            <input type="hidden" name="action" value="logout">
            <button type="submit">Logout</button>
        </form>
    </li>
</ul>


</body>
</html>
