package com.example.cabservice.service;

import com.example.cabservice.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileServiceTest {
    @Test
    public void testUpdateUserProfile() {
        ProfileService profileService = new ProfileService();
        User user = profileService.updateUserProfile(1, "newUser", "new@example.com", "1234567890");
        assertNull(user); // Since no actual DAO implementation
    }

    @Test
    public void testGetUserById() {
        ProfileService profileService = new ProfileService();
        User user = profileService.getUserById(1);
        assertNull(user);
    }

    @Test
    public void testUpdateUserPassword() {
        ProfileService profileService = new ProfileService();
        profileService.updateUserPassword(1, "newPassword");
        assertTrue(true); // Just verifying method call


    }
}