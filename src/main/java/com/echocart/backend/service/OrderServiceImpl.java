package com.echocart.backend.service;

import com.echocart.backend.entity.Order;
import com.echocart.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        order.setStatus(Order.Status.PENDING);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrderStatus(Long orderId, Order.Status status) {
        Order existing = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setStatus(status);
        return orderRepository.save(existing);
    }
}
