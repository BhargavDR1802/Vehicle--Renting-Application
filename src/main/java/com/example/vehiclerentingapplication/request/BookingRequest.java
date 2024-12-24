package com.example.vehiclerentingapplication.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequest {

	private double totalPayableAmount;
	private String rentingType;
	private String bookingStatus;

	private LocalDate pickUpDate;
	private LocalTime pickUpTime;

	private LocalDate dropDate;
	private LocalTime dropTime;
	
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public String getRentingType() {
		return rentingType;
	}
	public void setRentingType(String rentingType) {
		this.rentingType = rentingType;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public LocalDate getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public LocalTime getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public LocalDate getDropDate() {
		return dropDate;
	}
	public void setDropDate(LocalDate dropDate) {
		this.dropDate = dropDate;
	}
	public LocalTime getDropTime() {
		return dropTime;
	}
	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
	}



}
