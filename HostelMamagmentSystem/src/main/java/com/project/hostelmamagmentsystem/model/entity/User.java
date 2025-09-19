package com.project.hostelmamagmentsystem.model.entity;

import com.project.hostelmamagmentsystem.enums.UserEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(unique = true)
    String email;
    @Column(unique = true)
    String password;
    @Enumerated(EnumType.STRING)
    UserEnum role;



}
