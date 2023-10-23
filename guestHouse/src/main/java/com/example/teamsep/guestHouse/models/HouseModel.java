package com.example.teamsep.guestHouse.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="house")
public class HouseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOUSE_ID")
private Long id;
private String name;
private String address;
private String city;
private String description;
private String imgUrl;


@ManyToOne
@JoinColumn(name = "user_id", nullable = true)
private User user;

@OneToMany(mappedBy = "house", cascade = CascadeType.REMOVE)
private Set<RoomModel> room = new HashSet<>();



private HouseModel() {
}


private HouseModel(String name, String address, String city, String description, String imgUrl) {
	super();
	this.name = name;
	this.address = address;
	this.city = city;
	this.description = description;
	this.imgUrl = imgUrl;
}

public User getUser() {
   return user;
}

public void setUser(User user) {
   this.user = user;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
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


@Override
public String toString() {
	return "HouseModel [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", description="
			+ description + ", imgUrl=" + imgUrl + "]";
}


}
