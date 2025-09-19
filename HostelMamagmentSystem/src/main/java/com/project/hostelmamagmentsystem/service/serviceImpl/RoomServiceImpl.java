package com.project.hostelmamagmentsystem.service.serviceImpl;

import com.project.hostelmamagmentsystem.enums.RoomEnum;
import com.project.hostelmamagmentsystem.model.entity.Room;
import com.project.hostelmamagmentsystem.model.request.RoomRequest;
import com.project.hostelmamagmentsystem.repository.RoomRepository;
import com.project.hostelmamagmentsystem.service.RoomService;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public Room addRoom(String roomNumber,Long capacity,Long occupied,RoomEnum roomRole) {
        Room room=new Room();
        room.setRoomNumber(roomNumber);
        room.setCapacity(capacity);
        room.setOccupied(occupied);
        room.setRoomRole(RoomEnum.AVAILABLE);
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
    }

    @Override
    public List<Room> getAllRooms(String roomNumber) {
        return roomRepository.findAll();
    }

    @Override
    public void deleteRoom(Long id) {
     roomRepository.deleteById(id);
    }
}
