<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 06:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="register" method="post">
    <input type="hidden" name="action" value="register">

    <label>Full Name:</label>
    <input type="text" name="name" required>


    <label>Phone:</label>
    <input type="text" name="phone" required>

    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <button type="submit">Register</button>
</form>
