package com.example.teamsep.guestHouse.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamsep.guestHouse.models.HouseModel;
import com.example.teamsep.guestHouse.models.User;
import com.example.teamsep.guestHouse.repositories.HouseRepository;
import com.example.teamsep.guestHouse.repositories.UserRepository;
import com.example.teamsep.guestHouse.repositories.roomRepository;
import com.example.teamsep.guestHouse.services.HouseService;

@Service
public class HouseServiceImpl implements HouseService{
	@Autowired
	private HouseRepository houseRepo;
	@Autowired
	private roomRepository roomRepo;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
    public List<HouseModel> getAllHouses(String searchKeyword) {
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            // Search for houses by name based on the search keyword (case-insensitive)
            return houseRepo.findByNameIgnoreCaseContaining(searchKeyword);
        } else {
            // Return all houses
            return houseRepo.findAll();
            }
	}
        
	
	@Override
	public List<HouseModel> getAllHousesByUserId(Long userId) {
	    // Use the repository method to find houses by user ID
	    return houseRepo.findAllByUserId(userId);
	}


	@Override
	public HouseModel getHouseById(Long id) {
		// TODO Auto-generated method stub
		Optional<HouseModel> house = houseRepo.findById(id);
		return house.isPresent() ? house.get() : null;
	}

	@Override
	public void deleteHouseById(Long id) {
		// TODO Auto-generated method stub
		houseRepo.deleteById(id);
	}
	
	public void deleteHouseAndRooms(Long houseId) {
	    // Delete all rooms associated with the house
	    roomRepo.deleteAllByHouseId(houseId);

	    // Delete the house itself
	    houseRepo.deleteById(houseId);
	}


	@Override
	public HouseModel addHouse(HouseModel house) {
	    Long userId = house.getUser().getId(); // Assuming you can access the user's ID from the house object

	    // Fetch the user from the database based on the user ID
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

	    // Set the user for the house
	    house.setUser(user);

	    // Save the house with the user association
	    return houseRepo.save(house);
	}


	@Override
	public HouseModel editHouse(HouseModel house) {
		// TODO Auto-generated method stub
		return houseRepo.save(house);
	}

}
