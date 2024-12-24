package com.example.vehiclerentingapplication.entity;

import java.time.Duration;
import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	private double totalPayableAmount;

	@Enumerated(EnumType.STRING)
	private RentingType rentingType;

	private Duration duration;
	
	@ManyToOne
	private VehicleListing vehicleListing;

	@ManyToOne
	private User user;

	@OneToOne
	private PickUp pickUp;

	@OneToOne
	private Drop_Entity drop;

	public VehicleListing getVehicleListing() {
		return vehicleListing;
	}

	public void setVehicleListing(VehicleListing vehicleListing) {
		this.vehicleListing = vehicleListing;
	}
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public RentingType getRentingType() {
		return rentingType;
	}

	public void setRentingType(RentingType rentingType) {
		this.rentingType = rentingType;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PickUp getPickUp() {
		return pickUp;
	}

	public void setPickUp(PickUp pickUp) {
		this.pickUp = pickUp;
	}

	public Drop_Entity getDrop() {
		return drop;
	}

	public void setDrop(Drop_Entity drop) {
		this.drop = drop;
	}


}
