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

    public void init() {
        customerService = new CustomerService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            listCustomers(request, response);
        } else if ("edit".equals(action)) {
            showEditForm(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("updateStatus".equals(action)) {
            updateCustomerStatus(request, response);
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("managecustomers.jsp").forward(request, response);
    }

    private void updateCustomerStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = Integer.parseInt(request.getParameter("customerID"));
        String status = request.getParameter("status");

        customerService.updateCustomerStatus(userID, status);
        response.sendRedirect("customer?action=list&success=status_updated");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomerById(userID);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("edit_customer.jsp").forward(request, response);
    }
}