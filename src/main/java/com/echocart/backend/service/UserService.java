package com.echocart.backend.service;

import com.echocart.backend.entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String identifier, String password); // identifier can be email or username
    User getUserProfile(Long userId);
}
