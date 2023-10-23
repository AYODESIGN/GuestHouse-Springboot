package com.example.teamsep.guestHouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamsep.guestHouse.models.HouseModel;
import com.example.teamsep.guestHouse.services.HouseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/houses")


public class HouseController {
	@Autowired
	public HouseService houseService;

	 @GetMapping
	    public List<HouseModel> getAllHouses(@RequestParam(required = false) String searchKeyword) {
	        return houseService.getAllHouses(searchKeyword);
	    }
	
	@RequestMapping("/user/{userId}")
	public List<HouseModel> getHousesByUserId(@PathVariable Long userId) {
	    return houseService.getAllHousesByUserId(userId);
	}


	@GetMapping("/{id}")
	public HouseModel getHouse(@PathVariable Long id) {
		return houseService.getHouseById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteHouseById(@PathVariable Long id) {
		houseService.deleteHouseById(id);
	}

	@PostMapping
	public HouseModel addHouse(@RequestBody HouseModel house) {
		System.out.println(house);
		return houseService.addHouse(house);
	}

	@PutMapping
	public HouseModel editHouse(@RequestBody HouseModel house) {
		return houseService.editHouse(house);
	}

}
