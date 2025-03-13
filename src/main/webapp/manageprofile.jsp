<%@ page import="com.example.cabservice.model.User" %><%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 07-03-2025
  Time: 11:18 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession sessiom = request.getSession();
    User loggedInUser = (User) session.getAttribute("user");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Profile</title>
    <link rel="stylesheet" href="css\manageprofile.css">
</head>
<body>

<h2>Manage My Profile</h2>

<%-- Success Message --%>
<% if (request.getParameter("success") != null) { %>
<p class="success-message">Profile updated successfully!</p>
<% } %>

<%-- Profile Update Form --%>
<form action="Profile" method="post">
    <input type="hidden" name="action" value="updateProfile">
    <input type="hidden" name="userID" value="<%= loggedInUser.getUserID() %>">

    <label>Username:</label>
    <input type="text" name="username" value="<%= loggedInUser.getUsername() %>" required>

    <label>Email:</label>
    <input type="email" name="email" value="<%= loggedInUser.getEmail() %>" required>

    <label>Phone Number:</label>
    <input type="text" name="phone" value="<%= loggedInUser.getPhoneNumber() %>" required>

    <button type="submit">Update Profile</button>
</form>

<%-- Password Change Form --%>
<h3>Change Password</h3>
<form action="Profile" method="post">
    <input type="hidden" name="action" value="updatePassword">
    <input type="hidden" name="userID" value="<%= loggedInUser.getUserID() %>">

    <label>New Password:</label>
    <input type="password" name="password" required>

    <button type="submit">Change Password</button>
</form>

<%-- Logout and Navigation --%>
<form action="auth" method="post">
    <input type="hidden" name="action" value="logout">
    <button type="submit">Logout</button>
</form>

<a href="customer_dashboard.jsp">⬅ Back to Dashboard</a>

</body>
</html>
