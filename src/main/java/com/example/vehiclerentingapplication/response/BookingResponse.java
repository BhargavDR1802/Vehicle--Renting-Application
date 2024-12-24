package com.example.vehiclerentingapplication.response;

import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;

public class BookingResponse {

	private int bookingId;
	private BookingStatus bookingStatus;
	private RentingType rentingType;
	private double totalPayableAmount;
	
	private VehicleListingResponse vehicle;
	private VehicleResponse model;
	private PickUpResponse pickup;
	private DropResponse drop;

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
	public RentingType getRentingType() {
		return rentingType;
	}
	public void setRentingType(RentingType rentingType) {
		this.rentingType = rentingType;
	}
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public VehicleListingResponse getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleListingResponse vehicle) {
		this.vehicle = vehicle;
	}
	public VehicleResponse getModel() {
		return model;
	}
	public void setModel(VehicleResponse model) {
		this.model = model;
	}
	public PickUpResponse getPickup() {
		return pickup;
	}
	public void setPickup(PickUpResponse pickup) {
		this.pickup = pickup;
	}
	public DropResponse getDrop() {
		return drop;
	}
	public void setDrop(DropResponse drop) {
		this.drop = drop;
	}



}
