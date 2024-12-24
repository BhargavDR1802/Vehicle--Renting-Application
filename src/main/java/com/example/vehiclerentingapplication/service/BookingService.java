package com.example.vehiclerentingapplication.service;

import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.Booking;
import com.example.vehiclerentingapplication.entity.Drop_Entity;
import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.LocationNotFoundException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.mapper.BookingMapper;
import com.example.vehiclerentingapplication.mapper.LocationMapper;
import com.example.vehiclerentingapplication.mapper.VehicleListingMapper;
import com.example.vehiclerentingapplication.mapper.VehicleMapper;
import com.example.vehiclerentingapplication.repository.BookingRepository;
import com.example.vehiclerentingapplication.repository.DropRepository;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.PickUpRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.request.BookingRequest;
import com.example.vehiclerentingapplication.response.BookingResponse;
import com.example.vehiclerentingapplication.response.DropResponse;
import com.example.vehiclerentingapplication.response.PickUpResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final VehicleListingRepository vehicleListingRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final PickUpRepository pickUpRepository;
    private final DropRepository dropRepository;
    private final AuthUtil authUtil;
    private final BookingMapper bookingMapper;
    private final VehicleListingMapper listingMapper;
    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;
    private final LocationMapper locationMapper;

	

    public BookingService(BookingRepository bookingRepository, VehicleListingRepository vehicleListingRepository,
			UserRepository userRepository, LocationRepository locationRepository, PickUpRepository pickUpRepository,
			DropRepository dropRepository, AuthUtil authUtil, BookingMapper bookingMapper, VehicleListingMapper listingMapper,
			VehicleMapper vehicleMapper, VehicleRepository vehicleRepository, LocationMapper locationMapper) {
		super();
		this.bookingRepository = bookingRepository;
		this.vehicleListingRepository = vehicleListingRepository;
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
		this.pickUpRepository = pickUpRepository;
		this.dropRepository = dropRepository;
		this.authUtil = authUtil;
		this.bookingMapper = bookingMapper;
		this.listingMapper = listingMapper;
		this.vehicleMapper = vehicleMapper;
		this.vehicleRepository = vehicleRepository;
		this.locationMapper = locationMapper;
	}



	public BookingResponse createBooking(BookingRequest request,int vehicleListingId, int pickUpLocationId, int dropLocationId) {
    	
    	User currentuser = authUtil.getCurrentUser();
       
    	VehicleListing vehicleListing = vehicleListingRepository.findById(vehicleListingId)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle listing not found"));
        User user = userRepository.findById(currentuser.getUserId())
                .orElseThrow(() -> new UserNotFoundByIdException("User not found"));
        Location pickUpLocation = locationRepository.findById(pickUpLocationId)
                .orElseThrow(() -> new LocationNotFoundException("PickUp location not found"));
        Location dropLocation = locationRepository.findById(dropLocationId)
                .orElseThrow(() -> new LocationNotFoundException("Drop location not found"));
        /*
         * Fetching the Vehicle data explicitly as the Vehicle is loaded through LAZY behaviour*/
        Vehicle vehicle = vehicleRepository.findById(vehicleListing.getVehicle().getVehicleId())
        		.orElseThrow(() -> new VehicleNotFoundException("Failed to find the vehicle model"));
        
        PickUp pickUp = bookingMapper.mapToPickUp(request, new PickUp());
        pickUp.setLocation(pickUpLocation);
        
        Drop_Entity drop = bookingMapper.mapTodrop(request, new Drop_Entity()); 
        drop.setLocation(dropLocation);

        Booking booking = bookingMapper.mapToBooking(request,  new Booking());
        booking.setDrop(drop);
        booking.setPickUp(pickUp);
        booking.setUser(user);
        booking.setVehicleListing(vehicleListing);
        
        pickUp = pickUpRepository.save(pickUp);
        drop = dropRepository.save(drop);
        
        bookingRepository.save(booking);
        
       return this.buildBookingResponse(booking, drop, pickUp, vehicle, vehicleListing);
        
    }



	private BookingResponse buildBookingResponse(Booking booking, Drop_Entity drop, PickUp pickUp, Vehicle vehicle, VehicleListing vehicleListing) {
		 BookingResponse response = bookingMapper.mapToResponse(booking);
		 
		 	DropResponse dropResponse = bookingMapper.mapToDropResponse(drop);
		 	dropResponse.setLocationResponse(locationMapper.toResponse(drop.getLocation()));
	        response.setDrop(dropResponse);
	        
	        PickUpResponse pickUpResponse = bookingMapper.mapToPickupResponse(pickUp);
	        pickUpResponse.setLocationResponse(locationMapper.toResponse(pickUp.getLocation()));
	        response.setPickup(pickUpResponse);
	        
	        response.setModel(vehicleMapper.mapToResponse(vehicle));
	        response.setVehicle(listingMapper.mapToResponse(vehicleListing));
	        
	        return response;
	}
}
