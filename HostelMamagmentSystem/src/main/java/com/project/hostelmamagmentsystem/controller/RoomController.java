package com.project.hostelmamagmentsystem.controller;

import com.project.hostelmamagmentsystem.model.entity.Room;
import com.project.hostelmamagmentsystem.model.request.RoomRequest;
import com.project.hostelmamagmentsystem.service.RoomService;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/room")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RoomController {

    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody RoomRequest request) {
        Room room = roomService.addRoom(request.getRoomNumber(), request.getCapacity(), request.getOccupied(), request.getRoomEnum());
        return ResponseEntity.ok(room);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<List<Room>> getAllRooms(@PathVariable String roomNumber) {
        return ResponseEntity.ok(roomService.getAllRooms(roomNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.notFound().build();
    }


}
