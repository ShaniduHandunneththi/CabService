package com.example.cabservice.controller;

import com.example.cabservice.model.User;
import com.example.cabservice.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterController extends HttpServlet {
    private AuthService userService;


    public void init() {
        userService = new AuthService();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        String role = request.getParameter("role");

        // Create a generic User object (not customer-specific)
        User user = new User(username, phone, email, password);
        user.setUsername(username);
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setPassword(password);
//        user.setRole(role);

        if(userService.registerUser(user)){
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("user-register.jsp?error=Registration Failed or Email Already Exists");
        }
//        if (success) {
//            response.sendRedirect("login.jsp?message=Registration Successful");
//        } else {
//            response.sendRedirect("register.jsp?error=Registration Failed or Email Already Exists");
//        }
    }
}