<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 12-03-2025
  Time: 09:58 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Vehicle</title>
    <link rel="stylesheet" href="css\add_vehicle.css">
</head>
<body>
<h2>Add Vehicle</h2>

<form action="vehicle" method="post">
    <input type="hidden" name="action" value="add">

    <label>Vehicle Number:</label>
    <input type="text" name="vehicleNumber" required>

    <label>Model:</label>
    <input type="text" name="model" required>

    <label>Capacity:</label>
    <input type="number" name="capacity" required>

    <label>Status:</label>
    <select name="status">
        <option value="Available">Available</option>
        <option value="Unavailable">Unavailable</option>
    </select>

    <button type="submit">Add Vehicle</button>
</form>

<a href="vehicle?action=list">Back to Vehicle Management</a>
</body>
</html>