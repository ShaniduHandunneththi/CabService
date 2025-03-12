<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 07:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="css\login.css">
</head>
<body>
<div class="login-container">
    <h2>User Login</h2>
    <form action="auth?action=login" method="post">
        <input type="hidden" name="action" value="login">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
    <p class="error-message">
        <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
    </p>
    <div class="register-links">
        <p>Don't have an account? <a href="user-register.jsp">Register here</a></p>
        <p>Don't have a Driver account? <a href="register_driver.jsp">Register here</a></p>
    </div>
</div>
</body>
</html>
