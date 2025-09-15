package com.echocart.backend.service;

import com.echocart.backend.entity.Payment;
import com.echocart.backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment processPayment(Payment payment) {
        // Simulate payment gateway processing
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentStatus(Payment.PaymentStatus.COMPLETED); // In real case, set based on gateway response
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentStatus(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
