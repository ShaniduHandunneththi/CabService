<%--
  Created by IntelliJ IDEA.
  User: shani
  Date: 16-02-2025
  Time: 07:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="billing" method="post">
    <input type="hidden" name="action" value="generate">
    Booking ID: <input type="number" name="bookingID" required><br>
    Customer ID: <input type="number" name="customerID" required><br>
    Total Fare: <input type="number" step="0.01" name="totalFare" required><br>
    Payment Method:
    <select name="paymentMethod">
        <option value="Cash">Cash</option>
        <option value="Credit Card">Credit Card</option>
        <option value="Online">Online</option>
    </select><br>
    <button type="submit">Generate Bill</button>
</form>
