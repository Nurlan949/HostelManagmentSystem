package com.project.hostelmamagmentsystem.service.serviceImpl;

import com.project.hostelmamagmentsystem.enums.PaymentEnum;
import com.project.hostelmamagmentsystem.model.entity.Payment;
import com.project.hostelmamagmentsystem.model.entity.User;
import com.project.hostelmamagmentsystem.model.request.PaymentRequest;
import com.project.hostelmamagmentsystem.repository.PaymentRepository;
import com.project.hostelmamagmentsystem.repository.UserRepository;
import com.project.hostelmamagmentsystem.service.PaymentService;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PaymentServiceImpl implements PaymentService {
    PaymentRepository paymentRepository;
    UserRepository userRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Payment makePayment(Long userId, PaymentRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDateTime.now());
        if (request.getAmount() > 0.0) {
            payment.setStatus(PaymentEnum.PAID);

        } else {
            payment.setStatus(PaymentEnum.PENDING);

        }
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return paymentRepository.findByUser(user);
    }
}
