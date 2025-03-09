package com.example.cabservice.controller;

import com.example.cabservice.model.Billing;
import com.example.cabservice.service.BillingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BillingController extends HttpServlet {

    private BillingService billingService;

    @Override
    public void init() throws ServletException {
        billingService = new BillingService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("generate".equals(action)) {
            generateBill(request, response);
        }
    }

    private void generateBill(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        double totalFare = Double.parseDouble(request.getParameter("totalFare"));
        double tax = totalFare * 0.10;
        double discount = 0.00;
        double finalAmount = totalFare + tax - discount;

        Billing billing = new Billing();
        billing.setBookingID(bookingID);
        billing.setCustomerID(customerID);
        billing.setTotalFare(totalFare);
        billing.setTax(tax);
        billing.setDiscount(discount);
        billing.setFinalAmount(finalAmount);
        billing.setPaymentStatus("Pending");
        billing.setPaymentMethod(request.getParameter("paymentMethod"));

        boolean success = billingService.generateBill(billing);
        if (success) {
            response.sendRedirect("bill.jsp?message=Bill Generated Successfully");
        } else {
            response.sendRedirect("generate_bill.jsp?error=Bill Generation Failed");
        }
    }
}