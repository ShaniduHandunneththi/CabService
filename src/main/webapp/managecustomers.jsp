<%@ page import="com.example.cabservice.model.Booking" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 03-03-2025
  Time: 07:19 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cabservice.service.CustomerService" %>
<%@ page import="com.example.cabservice.model.Customer" %>

<%
    CustomerService customerService = new CustomerService();
    List<Customer> customers = customerService.getAllCustomers();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Customers</title>
    <link rel="stylesheet" href="styles.css"> <!-- Include CSS file -->
</head>
<body>
<h2>Manage Customers</h2>

<table border="1">
    <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    <% for (Customer customer : customers) { %>
    <tr>
        <td><%= customer.getUserID() %></td>
        <td><%= customer.getUsername() %></td>
        <td>
            <a href="CustomerController?action=edit&id=<%= customer.getUserID() %>">Edit</a> |
            <a href="CustomerController?action=delete&id=<%= customer.getUserID() %>"
               onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
        </td>
    </tr>
    <% } %>
</table>

<a href="add_customer.jsp">Add New Customer</a>
</body>
</html>
