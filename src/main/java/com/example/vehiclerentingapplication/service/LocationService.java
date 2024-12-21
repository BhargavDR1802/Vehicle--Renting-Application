package com.example.vehiclerentingapplication.service;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.request.LocationRequest;
import com.example.vehiclerentingapplication.response.LocationResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

	private LocationRepository locationRepository;
	private final AuthUtil authUtil;
	private LocationMapper locationMapper;
	private VehicleListingRepository vehicleListingRepository;

	public LocationService(LocationRepository locationRepository, AuthUtil authUtil, LocationMapper locationMapper,
			VehicleListingRepository vehicleListingRepository) {
		super();
		this.locationRepository = locationRepository;
		this.authUtil = authUtil;
		this.locationMapper = locationMapper;
		this.vehicleListingRepository = vehicleListingRepository;
	}



	public LocationResponse addLocation(LocationRequest locationRequest) {
		User user = authUtil.getCurrentUser();
		Location location = locationMapper.toLocation(locationRequest);
		location.setUser(user);
		Location savedLocation = locationRepository.save(location);

		return locationMapper.toResponse(savedLocation);
	}

	public List<LocationResponse> getAllLocations() {
		User user = authUtil.getCurrentUser();
		List<Location> locations = locationRepository.findAll();
		List<LocationResponse> locationResponses = new ArrayList<>();
		for (Location location : locations) {
			locationResponses.add(locationMapper.toResponse(location));
		}
		return locationResponses;
	}
	public List<LocationResponse> getLocationsByVehicleListingId(int listingId) {
		VehicleListing vehicleListing = vehicleListingRepository.findById(listingId).orElseThrow(()->new VehicleNotFoundException("Listing Not Found"));
		List<LocationResponse> locationResponses = new ArrayList();
		List<Location> vehicleLocations = vehicleListing.getLocations();		
		for (Location location : vehicleLocations) {
			locationResponses.add(locationMapper.toResponse(location));
		}
		return locationResponses;
	}

}