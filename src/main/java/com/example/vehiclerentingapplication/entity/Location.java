package com.example.vehiclerentingapplication.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	
	private String addressLine;
	
	private String addressLineOptional;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int pincode;
	
	private String phoneNumber;
	
	@ManyToOne
	private User user;
	
	@ManyToMany(mappedBy = "locations")//makes the vehicleListing as the owning side
	List<VehicleListing> vehicleListing;
	
	
	public int getLocationId() {
		return locationId;
	}

	public List<VehicleListing> getVehicleListing() {
		return vehicleListing;
	}

	public void setVehicleListing(List<VehicleListing> vehicleListing) {
		this.vehicleListing = vehicleListing;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressLineOptional() {
		return addressLineOptional;
	}

	public void setAddressLineOptional(String addressLineOptional) {
		this.addressLineOptional = addressLineOptional;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
