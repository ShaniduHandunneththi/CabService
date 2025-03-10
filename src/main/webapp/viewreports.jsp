<%@ page import="com.example.cabservice.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 04-03-2025
  Time: 08:45 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Reports</title>
    <link rel="stylesheet" href="styles.css"> <!-- Include CSS file -->
</head>
<body>
<h2>View Reports</h2>

<table border="1">
    <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Password</th> <!-- Ideally, passwords should not be displayed for security reasons -->
        <th>Role</th>
    </tr>

    <%
        List<User> users = (List<User>) request.getAttribute("userList");
        if (users != null) {
            for (User user : users) {
    %>
    <tr>
        <td><%= user.getUserID() %></td>
        <td><%= user.getUsername() %></td>
        <td>********</td> <!-- Masking password for security -->
        <td><%= user.getRole() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="4">No users found.</td></tr>
    <% } %>
</table>

</body>
</html>
