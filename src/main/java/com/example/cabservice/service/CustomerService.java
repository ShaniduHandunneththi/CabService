package com.example.cabservice.service;

import com.example.cabservice.dao.CustomerDAO;
import com.example.cabservice.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public boolean deleteCustomer(int userID) {
        return customerDAO.deleteCustomer(userID);
    }
}
