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
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Customers</title>
    <link rel="stylesheet" href="css\managecustomers.css">
</head>
<body>
<h2>Customer Management</h2>

<table>
    <tr>
        <th>Customer ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    <% if (customers != null) {
        for (Customer customer : customers) { %>
    <tr>
        <td><%= customer.getUserID() %></td>
        <td><%= customer.getUsername() %></td>
        <td><%= customer.getEmail() %></td>
        <td><%= customer.getPhone() %></td>
        <td><%= customer.getStatus() %></td>
        <td>
            <form action="customer" method="post">
                <input type="hidden" name="action" value="updateStatus">
                <input type="hidden" name="customerID" value="<%= customer.getUserID() %>">

                <select name="status">
                    <option value="Active" <% if("Active".equals(customer.getStatus())) { %>selected<% } %>>Active</option>
                    <option value="InActive" <% if("Inactive".equals(customer.getStatus())) { %>selected<% } %>>Inactive</option>
                    <option value="Banned" <% if("Suspended".equals(customer.getStatus())) { %>selected<% } %>>Ban</option>
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