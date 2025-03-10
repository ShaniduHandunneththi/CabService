<%@ page import="com.example.cabservice.model.Driver" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 04-03-2025
  Time: 02:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Drivers</title>
    <link rel="stylesheet" href="styles.css"> <!-- Include CSS file -->
</head>
<body>
<h2>Manage Drivers</h2>

<table border="1">
    <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>

    <%
        List<Driver> drivers = (List<Driver>) request.getAttribute("driverList");
        if (drivers != null) {
            for (Driver driver : drivers) {
    %>
    <tr>
        <td><%= driver.getUserID() %></td>
        <td><%= driver.getUsername() %></td>
        <td><%= driver.getRole() %></td>
        <td>
            <a href="DriverController?action=edit&id=<%= driver.getUserID() %>">Edit</a> |
            <a href="DriverController?action=delete&id=<%= driver.getUserID() %>"
               onclick="return confirm('Are you sure you want to delete this driver?');">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<a href="add_driver.jsp">Add New Driver</a>
</body>
</html>
