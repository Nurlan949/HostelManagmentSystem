package com.project.hostelmamagmentsystem.controller;

import com.project.hostelmamagmentsystem.enums.PaymentEnum;
import com.project.hostelmamagmentsystem.model.entity.Payment;
import com.project.hostelmamagmentsystem.model.request.PaymentRequest;
import com.project.hostelmamagmentsystem.model.response.PaymentResponse;
import com.project.hostelmamagmentsystem.service.PaymentService;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
///  Payment makePayment(Long userId, Double amount);
///     List<Payment> getPaymentsByUser(Long userId);
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/payment")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PaymentController {
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/make/{userId}")
    public PaymentResponse makePayment(@PathVariable Long userId ,@RequestBody PaymentRequest request) {
        Payment payment = paymentService.makePayment(userId,request);

        return PaymentResponse.builder().id(payment.getId()).amount(payment.getAmount()).status(payment.getStatus()).build();
    }

    @GetMapping("/user/{userId}")
    public List<PaymentResponse> getUserPayments(@PathVariable Long userId) {

        return paymentService.getPaymentsByUser(userId).stream().map(payment -> PaymentResponse.builder().id(payment.getId()).amount(payment.getAmount()).status((payment.getStatus())).build()).collect(Collectors.toList());


    }

}
