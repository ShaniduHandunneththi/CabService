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
    <title>My Profile</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Manage My Profile</h2>

<%-- Success Message --%>
<% if (request.getParameter("success") != null) { %>
<p style="color: green;">Profile updated successfully!</p>
<% } %>

<%-- Profile Update Form --%>
<form action="Profile" method="post">
    <input type="hidden" name="action" value="updateProfile">
    <input type="hidden" name="userID" value="<%= loggedInUser.getUserID() %>">

    <label>Username:</label>
    <input type="text" name="username" value="<%= loggedInUser.getUsername() %>" required><br>

    <label>Email:</label>
    <input type="email" name="email" value="<%= loggedInUser.getEmail() %>" required><br>

    <label>Phone Number:</label>
    <input type="text" name="phone" value="<%= loggedInUser.getPhoneNumber() %>" required><br>

    <button type="submit">Update Profile</button>
</form>

<%-- Password Change Form --%>
<h3>Change Password</h3>
<form action="Profile" method="post">
    <input type="hidden" name="action" value="updatePassword">
    <input type="hidden" name="userID" value="<%= loggedInUser.getUserID() %>">

    <label>New Password:</label>
    <input type="password" name="password" required><br>

    <button type="submit">Change Password</button>
</form>

<br>
<form action="auth" method="post">
    <button type="submit">Logout</button>
    <input type="hidden" name="action" value="logout">
</form>

</body>
</html>
