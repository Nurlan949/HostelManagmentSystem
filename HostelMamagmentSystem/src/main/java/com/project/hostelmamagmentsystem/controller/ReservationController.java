package com.project.hostelmamagmentsystem.controller;

import com.project.hostelmamagmentsystem.model.entity.Reservation;
import com.project.hostelmamagmentsystem.service.ReservationService;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/reservation")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ReservationController {

    ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestParam Long userId, @RequestParam Long roomId) {
      LocalDateTime startDate=LocalDateTime.now();
      LocalDateTime endDate=startDate.plusMonths(1);
      Reservation reservation=reservationService.createReservation(userId, roomId,startDate,endDate);
        return ResponseEntity.ok(reservation);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getReservationByUser(userId);
        if (reservations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservations);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.notFound().build();
    }


}
