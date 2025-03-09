package com.example.cabservice.service;

import com.example.cabservice.dao.UserDAO;
import com.example.cabservice.model.User;
import com.example.cabservice.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public User authenticate(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) { // Replace with hashed password check
            return user;
        }
        return null;
    }


    public boolean registerUser(User user) {
       return userDAO.registerUser(user);
    }

}

