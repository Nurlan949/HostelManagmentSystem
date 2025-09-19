package com.project.hostelmamagmentsystem.model.entity;

import com.project.hostelmamagmentsystem.enums.RoomEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomNumber;
    Long capacity;
    Long occupied;
    @Enumerated(EnumType.STRING)
    RoomEnum roomRole;


}
