package com.example.teamsep.guestHouse.services;

import com.example.teamsep.guestHouse.models.ReservationModel;

import java.util.List;

public interface ReservationService {
    List<ReservationModel> getAllReservations();
    List<ReservationModel> getReservationsByUserId(Long userId);
    ReservationModel getReservationById(Long id);
    void deleteReservationById(Long id);
    ReservationModel addReservation(ReservationModel reservation);
    ReservationModel editReservation(ReservationModel reservation);
}
