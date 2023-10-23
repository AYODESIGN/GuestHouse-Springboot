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
import org.springframework.web.bind.annotation.RestController;

import com.example.teamsep.guestHouse.models.RoomModel;
import com.example.teamsep.guestHouse.services.RoomService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/houses/room")

public class RoomController {
		@Autowired
		public RoomService roomService;

		@GetMapping
		public List<RoomModel> getAllRooms() {
			return roomService.getAllRooms();
		}
		
		@RequestMapping("/user/{userId}")
		public List<RoomModel> getRoomsByUserId(@PathVariable Long userId) {
		    return roomService.getAllRoomsByHouseId(userId);
		}


		@GetMapping("/{id}")
		public RoomModel getRoom(@PathVariable Long id) {
			return roomService.getRoomById(id);
		}

		@DeleteMapping("/{id}")
		public void deleteRoomById(@PathVariable Long id) {
			roomService.deleteRoomById(id);
		}

		@PostMapping("/add")
		public RoomModel addRoom(@RequestBody RoomModel room) {
			System.out.println(room);
			return roomService.addRoom(room);
		}

		@PutMapping
		public RoomModel editRoom(@RequestBody RoomModel room) {
			return roomService.editRoom(room);
		}

	}

