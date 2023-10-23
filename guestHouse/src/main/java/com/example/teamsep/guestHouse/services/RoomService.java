package com.example.teamsep.guestHouse.services;

import java.util.List;

import com.example.teamsep.guestHouse.models.RoomModel;

public interface RoomService {
public List<RoomModel> getAllRooms();
public List<RoomModel> getAllRoomsByHouseId(Long userId);
public RoomModel getRoomById(Long id);
public void deleteRoomById(Long id);
public RoomModel addRoom(RoomModel room);
public RoomModel editRoom(RoomModel room);
public void deleteAllRoomsByHouseId(Long houseId);
}
