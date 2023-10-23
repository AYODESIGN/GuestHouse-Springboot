package com.example.teamsep.guestHouse.repositories;

import com.example.teamsep.guestHouse.models.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {
    List<ReservationModel> findAllByUserId(Long userId);
}
