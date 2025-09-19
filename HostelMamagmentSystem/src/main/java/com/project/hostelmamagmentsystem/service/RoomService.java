package com.project.hostelmamagmentsystem.service;

import com.project.hostelmamagmentsystem.enums.RoomEnum;
import com.project.hostelmamagmentsystem.model.entity.Room;
import com.project.hostelmamagmentsystem.model.request.RoomRequest;

import java.util.List;

public interface RoomService {
    Room addRoom(String roomNumber,Long capacity,Long occupied,RoomEnum roomRole);
    Room getRoomById(Long id);
    List<Room> getAllRooms(String roomNumber);
    void deleteRoom(Long id);
}
