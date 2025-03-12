<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 06:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration</title>
    <link rel="stylesheet" href="css\user-register.css">
</head>
<body>
<div class="registration-container">
    <h2>Register as a Customer</h2>
    <form action="register" method="post">
        <input type="hidden" name="action" value="register">

        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Phone:</label>
        <input type="text" name="phone" required>

        <button type="submit">Register</button>
    </form>

    <a href="login.jsp">Back to Dashboard</a>
</div>
</body>
</html>

