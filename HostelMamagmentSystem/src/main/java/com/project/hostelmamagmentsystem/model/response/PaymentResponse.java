package com.project.hostelmamagmentsystem.model.response;

import com.project.hostelmamagmentsystem.enums.PaymentEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
public class PaymentResponse {
    Long id;
    Double amount;
    @Enumerated(EnumType.STRING)
    PaymentEnum status;
}

