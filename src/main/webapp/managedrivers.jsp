<%@ page import="com.example.cabservice.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cabservice.model.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Driver> drivers = (List<Driver>) request.getAttribute("driverList");
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Drivers</title>
    <link rel="stylesheet" href="css\managedrivers.css">
</head>
<body>
<h2>Driver Management</h2>

<table>
    <tr>
        <th>Driver ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
        <th>License Number</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <% if (drivers != null) {
        for (Driver driver : drivers) { %>
    <tr>
        <td><%= driver.getUserID() %></td>
        <td><%= driver.getUsername() %></td>
        <td><%= driver.getEmail() %></td>
        <td><%= driver.getPhone() %></td>
        <td><%= driver.getLicenseNumber() %></td>
        <td><%= driver.getStatus() %></td>
        <td>
            <form action="driver" method="post">
                <input type="hidden" name="action" value="updateStatus">
                <input type="hidden" name="driverID" value="<%= driver.getUserID() %>">

                <select name="status">
                    <option value="Active" <% if("Active".equals(driver.getStatus())) { %>selected<% } %>>Active</option>
                    <option value="Inactive" <% if("Inactive".equals(driver.getStatus())) { %>selected<% } %>>Inactive</option>
                    <option value="Banned" <% if("Suspended".equals(driver.getStatus())) { %>selected<% } %>>Ban</option>
                </select>

                <button type="submit">Update</button>
            </form>
        </td>
    </tr>
    <% } } %>
</table>

<a href="admin_dashboard.jsp">Back to Dashboard</a>

</body>
</html>
