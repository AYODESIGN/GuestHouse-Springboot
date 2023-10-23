package com.example.teamsep.guestHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teamsep.guestHouse.models.HouseModel;

@Repository
public interface HouseRepository extends JpaRepository<HouseModel, Long> {
	   List<HouseModel> findAllByUserId(Long userId);
	    List<HouseModel> findByNameIgnoreCaseContaining(String name);

}
