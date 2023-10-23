package com.example.teamsep.guestHouse.services;

import java.util.List;

import com.example.teamsep.guestHouse.models.HouseModel;

public interface HouseService {

public List<HouseModel> getAllHouses(String searchKeyword);
public List<HouseModel> getAllHousesByUserId(Long userId);
public HouseModel getHouseById(Long id);
public void deleteHouseById(Long id);
public HouseModel addHouse(HouseModel house);
public HouseModel editHouse(HouseModel house);
}
