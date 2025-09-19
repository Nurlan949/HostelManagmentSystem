package com.project.hostelmamagmentsystem.service.serviceImpl;

import com.project.hostelmamagmentsystem.model.entity.Reservation;
import com.project.hostelmamagmentsystem.model.entity.Room;
import com.project.hostelmamagmentsystem.model.entity.User;
import com.project.hostelmamagmentsystem.repository.ReservationRepository;
import com.project.hostelmamagmentsystem.repository.RoomRepository;
import com.project.hostelmamagmentsystem.repository.UserRepository;
import com.project.hostelmamagmentsystem.service.ReservationService;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ReservationServiceImpl implements ReservationService {
    ReservationRepository reservationRepository;
    UserRepository userRepository;
    RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Reservation createReservation(Long userId, Long roomId,LocalDateTime startDate,LocalDateTime endDate) {
        
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Room room=roomRepository.findById(roomId).orElseThrow(()->new RuntimeException("Room not found"));
        Reservation reservation=new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);

        return reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> getReservationByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
