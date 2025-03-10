package com.example.cabservice.service;

import com.example.cabservice.dao.UserDAO;
import com.example.cabservice.model.User;

public class ProfileService {
    private UserDAO userDAO;

    public ProfileService() {
        this.userDAO = new UserDAO();
    }

    public User updateUserProfile(int userId, String username, String email, String phone) {
       if(userDAO.updateProfile(userId, username, email, phone)){
           return userDAO.getUserById(userId);
       }
       return null;
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }
    public void updateUserPassword(int userId, String newPassword) {
        userDAO.updatePassword(userId, newPassword);
    }
}
