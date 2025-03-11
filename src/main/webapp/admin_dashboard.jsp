<%@ page import="com.example.cabservice.model.Admin" %>
<%@ page import="com.example.cabservice.model.User" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 07:42 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User admin = (User) request.getSession().getAttribute("user");
%>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<h2>Welcome, <%= admin.getUsername() %></h2>
<ul>
    <li><a href="booking.jsp">Manage Bookings</a></li>
    <li><a href="customer?action=list">Manage Customers</a></li>
    <li><a href="driver">Manage Drivers</a></li>
    <li><a href="vehicle?action=list">Manage Vehicles</a></li>
    <li><a href="viewreports.jsp">View Reports</a></li>
    <li>
        <form action="admin" method="post">
            <input type="hidden" name="action" value="logout">
            <button type="submit">Logout</button>
        </form>
    </li>
</ul>
</body>
</html>
