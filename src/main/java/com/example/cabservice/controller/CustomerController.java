package com.example.cabservice.controller;

import com.example.cabservice.dao.CustomerDAO;
import com.example.cabservice.model.Customer;
import com.example.cabservice.service.CustomerService;
import com.example.cabservice.utils.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class CustomerController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {

        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        request.setAttribute("customerList", customers);
        request.getRequestDispatcher("managecustomers.jsp").forward(request, response);
    }
}