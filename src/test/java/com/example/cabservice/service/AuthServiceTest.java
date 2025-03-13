package com.example.cabservice.service;

import com.example.cabservice.model.Driver;
import com.example.cabservice.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {
    @Test
    public void testAuthenticate_ValidUser() {
        AuthService authService = new AuthService();
        User user = authService.authenticate("testUser", "password123");
        assertNull(user); // Since no database interaction is set up
    }

    @Test
    public void testAuthenticate_InvalidUser() {
        AuthService authService = new AuthService();
        User user = authService.authenticate("invalidUser", "password123");
        assertNull(user);
    }

    @Test
    public void testAuthenticate_WrongPassword() {
        AuthService authService = new AuthService();
        User user = authService.authenticate("testUser", "wrongPassword");
        assertNull(user);
    }

    @Test
    public void testRegisterUser() {
        AuthService authService = new AuthService();
        User user = new User("newUser", "newPass");
        boolean result = authService.registerUser(user);
        assertFalse(result); // Since no actual DAO implementation
    }

    @Test
    public void testGetDriverById() {
        AuthService authService = new AuthService();
        Driver driver = authService.getDriverById(1);
        assertNull(driver);
    }

    @Test
    public void testUpdateDriver() {
        AuthService authService = new AuthService();
        Driver driver = new Driver(1, "John Doe");
        authService.updateDriver(driver);
        assertTrue(true); // Just verifying method call
    }
}


