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
public class Drop_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int dropId;

	private LocalDate date;

	private LocalTime time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}