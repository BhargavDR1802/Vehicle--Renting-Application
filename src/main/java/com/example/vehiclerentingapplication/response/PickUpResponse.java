package com.example.vehiclerentingapplication.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class PickUpResponse {
	private int pickUpId;
	private LocalDate date;
	private LocalTime time;
	private LocationResponse location;
	public int getPickUpId() {
		return pickUpId;
	}
	public void setPickUpId(int pickUpId) {
		this.pickUpId = pickUpId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocationResponse getLocation() {
		return location;
	}
	public void setLocationResponse(LocationResponse location) {
		this.location = location;
	}
	
	

}
