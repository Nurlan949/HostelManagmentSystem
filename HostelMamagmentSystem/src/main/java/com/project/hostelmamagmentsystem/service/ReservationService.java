package com.project.hostelmamagmentsystem.service;

import com.project.hostelmamagmentsystem.model.entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Long userId, Long roomId,LocalDateTime startDate,LocalDateTime endDate);
    List<Reservation> getReservationByUser(Long userId);
    void cancelReservation(Long bookingId);

}
