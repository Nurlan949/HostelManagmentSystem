package com.project.hostelmamagmentsystem.model.request;

import com.project.hostelmamagmentsystem.enums.RoomEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class RoomRequest  {
    String roomNumber;
    Long capacity;
    Long occupied;
    @Enumerated(EnumType.STRING)
    RoomEnum roomEnum;


}
