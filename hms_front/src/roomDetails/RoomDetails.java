package com.example.demo.roomDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RoomDetails")
public class RoomDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(length=7, unique=true)
	private String roomNumber;
	@Column(length=25)
	private String roomType;	
	@Column(length=3)
	private int totalBeds;
	@Column(length=3)
	private int availableBeds;

	public RoomDetails() {
		
	}
	
	public RoomDetails(int id, String roomNumber, String roomType, int totalBeds, int availableBeds ) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.totalBeds = totalBeds;
		this.availableBeds = availableBeds;
	}
	
	public int getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getTotalBeds() {
		return totalBeds;
	}
	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}
	
}
