package com.example.vehiclerentingapplication.controller;

import com.example.vehiclerentingapplication.request.BookingRequest;
import com.example.vehiclerentingapplication.response.BookingResponse;
import com.example.vehiclerentingapplication.service.BookingService;
import com.example.vehiclerentingapplication.util.ResponseStructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<ResponseStructure<BookingResponse>> createBooking(
			@RequestBody BookingRequest request,
			@RequestParam int vehicleListingId,
			@RequestParam int pickUpLocationId,
			@RequestParam int dropLocationId) {

		BookingResponse response = bookingService.createBooking(request, vehicleListingId, pickUpLocationId, dropLocationId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Booking Created", response));

	}
}
