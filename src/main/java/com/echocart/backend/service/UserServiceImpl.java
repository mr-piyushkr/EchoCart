package com.echocart.backend.service;

import com.echocart.backend.entity.User;
import com.echocart.backend.entity.Order;
import com.echocart.backend.entity.Product;
import com.echocart.backend.repository.UserRepository;
import com.echocart.backend.repository.OrderRepository;
import com.echocart.backend.repository.ProductRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository,
                           ProductRepository productRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ==================== CUSTOMER & ADMIN COMMON METHODS ====================

    @Override
    public User registerUser(User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole() != null ? user.getRole() : User.Role.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User loginUser(String identifier, String password) {
        if (identifier == null || identifier.trim().isEmpty()) {
            throw new IllegalArgumentException("Email/Username cannot be empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        Optional<User> userOpt = userRepository.findByUsernameOrEmail(identifier);

        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt.get();
        }

        throw new RuntimeException("Invalid credentials");
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserProfile(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    // ==================== ADMIN ONLY METHODS ====================

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getAdminDashboard() {
        Map<String, Object> dashboard = new HashMap<>();

        // User Statistics
        long totalUsers = userRepository.count();
        long totalCustomers = userRepository.countByRole(User.Role.CUSTOMER);
        long totalAdmins = userRepository.countByRole(User.Role.ADMIN);

        // Order Statistics
        long totalOrders = orderRepository.count();
        long pendingOrders = orderRepository.countByStatus(Order.Status.PENDING);
        long shippedOrders = orderRepository.countByStatus(Order.Status.SHIPPED);
        long deliveredOrders = orderRepository.countByStatus(Order.Status.DELIVERED);
        long cancelledOrders = orderRepository.countByStatus(Order.Status.CANCELLED);

        // Product Statistics
        long totalProducts = productRepository.count();

        dashboard.put("users", Map.of(
                "total", totalUsers,
                "customers", totalCustomers,
                "admins", totalAdmins
        ));

        dashboard.put("orders", Map.of(
                "total", totalOrders,
                "pending", pendingOrders,
                "shipped", shippedOrders,
                "delivered", deliveredOrders,
                "cancelled", cancelledOrders
        ));

        dashboard.put("products", Map.of(
                "total", totalProducts
        ));

        return dashboard;
    }

    @Override
    public User updateUserRole(Long userId, User.Role newRole) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (newRole == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        user.setRole(newRole);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        userRepository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersByRole(User.Role role) {
        return userRepository.findByRole(role);
    }
}