package com.example.cabservice.service;

import com.example.cabservice.dao.CustomerDAO;
import com.example.cabservice.model.Customer;
import com.example.cabservice.model.User;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void updateCustomerStatus(int userID, String status) {
        customerDAO.updateCustomerStatus(userID, status);
    }

    public Customer getCustomerById(int userID) {
        return customerDAO.getCustomerById(userID);
    }
}
