package com.example.vehiclerentingapplication.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PickUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pickUpId;

	private LocalDate date;

	private LocalTime time;

	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
