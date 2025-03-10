<%@ page import="com.example.cabservice.model.User" %><% User customer; %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 03-03-2025
  Time: 03:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User Customer = (User) request.getSession().getAttribute("user");
%>
<html lang="en">
<head>
    <title>Customer Dashboard</title>
</head>
<body>
<h2>Welcome, <%= Customer.getUsername() %></h2>

<ul>
    <li><a href="bookaride.jsp">Book a Ride</a></li>
    <li><a href="managebookings.jsp">View & Manage Bookings</a></li>
    <li><a href="manageprofile.jsp">Profile & Account Management</a></li>
</ul>

<form action="admin" method="post">
    <input type="hidden" name="action" value="logout">
    <button type="submit">Logout</button>
</form>
</body>
</html>