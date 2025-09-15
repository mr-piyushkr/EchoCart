package com.echocart.backend.service;

import com.echocart.backend.entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
    User getUserProfile(Long userId);
}
