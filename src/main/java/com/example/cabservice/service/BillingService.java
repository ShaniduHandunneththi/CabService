package com.example.cabservice.service;

import com.example.cabservice.dao.BillingDAO;
import com.example.cabservice.model.Billing;

public class BillingService {
    private BillingDAO billingDAO;

    public BillingService() {
        this.billingDAO = new BillingDAO();
    }

    public boolean generateBill(Billing billing) {
        return billingDAO.generateBill(billing);
    }

    public Billing getBillByBookingID(int bookingID) {
        return billingDAO.getBillByBookingID(bookingID);
    }
}
