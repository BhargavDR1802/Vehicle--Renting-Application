package com.example.vehiclerentingapplication.response;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.vehiclerentingapplication.entity.Location;

public class DropResponse {
	private int dropId;
	private LocalDate date;
	private LocalTime time;
	private LocationResponse location;
	public int getDropId() {
		return dropId;
	}
	public void setDropId(int dropId) {
		this.dropId = dropId;
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
