package com.example.cabservice.controller;

import com.example.cabservice.model.User;
import com.example.cabservice.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ProfileController extends HttpServlet {

    ProfileService profileService = new ProfileService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("updateProfile".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userID"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            User user = profileService.updateUserProfile(userId, username, email, phone);
            if (user!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("manageprofile.jsp?success=true");
            }
            else{
                response.sendRedirect("manageprofile.jsp?error=true");
            }
        }

        if ("updatePassword".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userID"));
            String newPassword = request.getParameter("password");

            profileService.updateUserPassword(userId, newPassword);
            response.sendRedirect("manageprofile.jsp?success=true");
        }
    }
}
