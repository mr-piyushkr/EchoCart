package com.echocart.backend.controller;

import com.echocart.backend.entity.User;
import com.echocart.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // match your frontend origin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Map<String, String> payload) {
        try {
            User user = new User();
            user.setUsername(payload.get("name")); // frontend sends "name"
            user.setEmail(payload.get("email"));
            user.setPassword(payload.get("password"));
            user.setRole(User.Role.CUSTOMER);

            userService.registerUser(user);
            return ResponseEntity.ok(Map.of("success", true, "message", "Registration successful!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> credentials) {
        try {
            String emailOrUsername = credentials.get("email"); // frontend sends "email"
            String password = credentials.get("password");

            userService.loginUser(emailOrUsername, password);
            return ResponseEntity.ok(Map.of("success", true, "message", "Login successful!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("success", false, "message", "Invalid email or password."));
        }
    }

    // GET PROFILE
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.getUserProfile(userId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
