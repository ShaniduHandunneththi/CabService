package com.example.cabservice.service;

import com.example.cabservice.model.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {


    @Test
    public void testUpdateCustomerStatus() {
        CustomerService customerService = new CustomerService();
        customerService.updateCustomerStatus(1, "Active");
        assertTrue(true); // Just verifying method call
    }

    @Test
    public void testGetCustomerById() {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomerById(1);
        assertNull(customer);


    }
}