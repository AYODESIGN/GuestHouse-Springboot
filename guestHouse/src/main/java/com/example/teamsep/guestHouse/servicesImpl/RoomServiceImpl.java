package com.example.teamsep.guestHouse.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamsep.guestHouse.models.HouseModel;
import com.example.teamsep.guestHouse.models.RoomModel;
import com.example.teamsep.guestHouse.repositories.HouseRepository;
import com.example.teamsep.guestHouse.repositories.roomRepository;
import com.example.teamsep.guestHouse.services.RoomService;


@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private HouseRepository houseRepo;
	@Autowired
	private roomRepository roomRepo;
	@Override
	public List<RoomModel> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepo.findAll();
	}

	@Override
	public List<RoomModel> getAllRoomsByHouseId(Long houseId) {
		// TODO Auto-generated method stub
		return roomRepo.findAllByHouseId(houseId);
	}

	@Override
	public RoomModel getRoomById(Long id) {
		/// TODO Auto-generated method stub
		Optional<RoomModel> room = roomRepo.findById(id);
		return room.isPresent() ? room.get() : null;
	}

	@Override
	public void deleteRoomById(Long id) {
		// TODO Auto-generated method stub
		roomRepo.deleteById(id);

	}

	public void deleteAllRoomsByHouseId(Long id) {
		roomRepo.deleteAllByHouseId(id);
	}
	
	@Override
	public RoomModel addRoom(RoomModel room) {
	    Long houseId = room.getHouse().getId(); // Assuming you can access the house's ID from the room object

	    // Fetch the house from the database based on the house ID
	    HouseModel house = houseRepo.findById(houseId)
	            .orElseThrow(() -> new EntityNotFoundException("House not found with ID: " + houseId));

	    // Set the house for the room
	    room.setHouse(house);

	    // Save the room with the house association
	    return roomRepo.save(room);
	}


	@Override
	public RoomModel editRoom(RoomModel room) {
		// TODO Auto-generated method stub
		return null;
	}

}
