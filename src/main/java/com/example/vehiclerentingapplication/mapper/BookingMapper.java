package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Booking;
import com.example.vehiclerentingapplication.entity.Drop_Entity;
import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;
import com.example.vehiclerentingapplication.request.BookingRequest;
import com.example.vehiclerentingapplication.response.BookingResponse;
import com.example.vehiclerentingapplication.response.DropResponse;
import com.example.vehiclerentingapplication.response.PickUpResponse;

@Component
public class BookingMapper {

	public Booking mapToBooking(BookingRequest request, Booking booking) {
		booking.setBookingStatus(BookingStatus.valueOf(request.getBookingStatus()));
		booking.setTotalPayableAmount(request.getTotalPayableAmount());
		booking.setRentingType(RentingType.valueOf(request.getRentingType()));

		return booking;
	}

	public PickUp mapToPickUp(BookingRequest request, PickUp pickUp) {
		pickUp.setDate(request.getPickUpDate());
		pickUp.setTime(request.getPickUpTime());
		return pickUp;
	}

	public Drop_Entity mapTodrop(BookingRequest request, Drop_Entity drop) {
		drop.setDate(request.getDropDate());
		drop.setTime(request.getDropTime());
		return drop;
	}

	public BookingResponse mapToResponse(Booking booking) {
		BookingResponse response = new BookingResponse();
		response.setBookingId(booking.getBookingId());
		response.setBookingStatus(booking.getBookingStatus());
		response.setRentingType(booking.getRentingType());
		response.setTotalPayableAmount(booking.getTotalPayableAmount());

		return response;
	}

	public DropResponse mapToDropResponse(Drop_Entity drop) {
		DropResponse response = new DropResponse();
		response.setDate(drop.getDate());
		response.setTime(drop.getTime());
		response.setDropId(drop.getDropId());
		return response;
	}

	public PickUpResponse mapToPickupResponse(PickUp pickUp) {
		PickUpResponse response = new PickUpResponse();
		response.setDate(pickUp.getDate());
		response.setTime(pickUp.getTime());
		response.setPickUpId(pickUp.getPickUpId());
		return response;
		
	}

}
