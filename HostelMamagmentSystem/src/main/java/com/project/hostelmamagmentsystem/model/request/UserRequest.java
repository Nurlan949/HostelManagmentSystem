package com.project.hostelmamagmentsystem.model.request;

import com.project.hostelmamagmentsystem.enums.UserEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class UserRequest {
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    UserEnum role;
}
