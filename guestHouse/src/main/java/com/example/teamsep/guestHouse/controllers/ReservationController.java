package com.example.teamsep.guestHouse.controllers;

import com.example.teamsep.guestHouse.models.ReservationModel;
import com.example.teamsep.guestHouse.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationModel> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/user/{userId}")
    public List<ReservationModel> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ReservationModel getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }

    @PostMapping
    public ReservationModel addReservation(@RequestBody ReservationModel reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping
    public ReservationModel editReservation(@RequestBody ReservationModel reservation) {
        return reservationService.editReservation(reservation);
    }
}
