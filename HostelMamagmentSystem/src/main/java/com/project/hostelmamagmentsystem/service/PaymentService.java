package com.project.hostelmamagmentsystem.service;

import com.project.hostelmamagmentsystem.model.entity.Payment;
import com.project.hostelmamagmentsystem.model.request.PaymentRequest;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Long userId, PaymentRequest request);
    List<Payment> getPaymentsByUser(Long userId);

}
