<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 07:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<h2>Admin Login</h2>
<form action="admin?action=login" method="post">
    <input type="hidden" name="action" value="login">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <button type="submit">Login</button>
</form>
<p style="color:red;">
    <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
</p>
</body>
</html>