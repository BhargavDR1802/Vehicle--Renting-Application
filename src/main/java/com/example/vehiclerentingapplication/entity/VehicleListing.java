package com.example.vehiclerentingapplication.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.vehiclerentingapplication.enums.Seating;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleListing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listingId;

	private String vehicleNo;

	private double pricePerDay;

	@Enumerated(EnumType.STRING)
	private Seating seating;

	@ManyToOne(fetch = FetchType.LAZY)
	private User rentingPartner;

	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;	
	
	@ManyToMany
	private List<Location> locations = new ArrayList();

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public double getPricePerDay() {	
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Seating getSeating() {
		return seating;
	}

	public void setSeating(Seating seating) {
		this.seating = seating;
	}

	public User getRentingPartner() {
		return rentingPartner;
	}

	public void setRentingPartner(User rentingPartner) {
		this.rentingPartner = rentingPartner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}




}
