package com.project.hostelmamagmentsystem.model.entity;

import com.project.hostelmamagmentsystem.enums.PaymentEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double amount = 0.0;
    LocalDateTime paymentDate;
    @Enumerated(EnumType.STRING)
    PaymentEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


}
