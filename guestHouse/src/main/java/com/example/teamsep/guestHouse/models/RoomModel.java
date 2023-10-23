package com.example.teamsep.guestHouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="room")
public class RoomModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROOM_ID")
private Long id;
private String name;
private int capacity;
private int price;
private String description;
private String imgUrl;


@ManyToOne
@JoinColumn(name = "HOUSE_ID", nullable = true)
@OnDelete(action = OnDeleteAction.CASCADE)
private HouseModel house;



private RoomModel() {
}



private RoomModel(String name, int capacity, int price, String description, String imgUrl, HouseModel house) {
	
	this.name = name;
	this.capacity = capacity;
	this.price = price;
	this.description = description;
	this.imgUrl = imgUrl;
	this.house = house;
}



public Long getId() {
	return id;
}

public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public int getCapacity() {
	return capacity;
}



public void setCapacity(int capacity) {
	this.capacity = capacity;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getImgUrl() {
	return imgUrl;
}



public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}



public HouseModel getHouse() {
	return house;
}



public void setHouse(HouseModel house) {
	this.house = house;
}

@Override
public String toString() {
	return "RoomModel [id=" + id + ", name=" + name + ", capacity=" + capacity + ", price=" + price + ", description="
			+ description + ", imgUrl=" + imgUrl + ", house=" + house + "]";
}
}


