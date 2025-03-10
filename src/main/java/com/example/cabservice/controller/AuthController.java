package com.example.cabservice.controller;

import com.example.cabservice.model.User;
import com.example.cabservice.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthController extends HttpServlet {

    private AuthService authService;

    @Override
    public void init() throws ServletException {
        authService = new AuthService(); // Initialize service layer
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            login(request, response);
        } else if ("logout".equals(action)) {
            logout(request, response);
        } else {
            response.sendRedirect("login.jsp?error=Invalid action");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = authService.authenticate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", user.getUserID());
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            // Redirect based on role
            if ("Admin".equals(user.getRole())) {
                response.sendRedirect("admin_dashboard.jsp");
            } else if ("Customer".equals(user.getRole())) {
                response.sendRedirect("customer_dashboard.jsp");
            } else if ("Driver".equals(user.getRole())) {
                response.sendRedirect("driver_dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate session
        }
        response.sendRedirect("login.jsp?message=Logged out successfully");
    }

}
