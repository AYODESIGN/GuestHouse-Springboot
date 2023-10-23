package com.example.teamsep.guestHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.teamsep.guestHouse.models.RoomModel;

@Repository
public interface roomRepository extends JpaRepository<RoomModel, Long> {
	   List<RoomModel> findAllByHouseId(Long houseId);
	   
	   @Query("DELETE FROM RoomModel r WHERE r.house.id = :houseId")
	    void deleteAllByHouseId(@Param("houseId") Long houseId);
}
