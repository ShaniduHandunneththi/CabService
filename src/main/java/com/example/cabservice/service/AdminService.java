package com.example.cabservice.service;

import com.example.cabservice.dao.AdminDAO;
import com.example.cabservice.model.Admin;

public class AdminService {
    private AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO = new AdminDAO();
    }

    public Admin login(String username, String password) {
        return adminDAO.login(username, password);
    }
}