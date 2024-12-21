package com.example.vehiclerentingapplication.service;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.LocationNotFoundException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.mapper.VehicleListingMapper;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.request.VehicleListingRequest;
import com.example.vehiclerentingapplication.response.VehicleListingResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleListingService {

	private VehicleListingRepository vehicleListingRepository;

	private VehicleRepository vehicleRepository;

	private VehicleListingMapper vehicleListingMapper;

	private final AuthUtil authUtil;
	
	@Autowired
	private LocationRepository locationRepository;

	public VehicleListingService(VehicleListingRepository vehicleListingRepository, UserRepository userRepository,
			VehicleRepository vehicleRepository, VehicleListingMapper vehicleListingMapper, AuthUtil authUtil) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.authUtil = authUtil;
	}

	public VehicleListingResponse createVehicleListing(VehicleListingRequest request, int vehicleId) {
		User rentingPartner = authUtil.getCurrentUser();
		VehicleListing vehicleListing = vehicleListingMapper.mapToListing(request);
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		vehicleListing.setVehicle(vehicle.get());
		vehicleListing.setRentingPartner(rentingPartner);
		VehicleListing savedListing = vehicleListingRepository.save(vehicleListing);

		return vehicleListingMapper.mapToResponse(savedListing);
	}

	public List<VehicleListingResponse> getAllVehicleListings() {
		List<VehicleListing> vehicleListings = vehicleListingRepository.findAll();
		List<VehicleListingResponse> responseList = new ArrayList<>();

		for (VehicleListing vehicleListing : vehicleListings) {
			VehicleListingResponse response = vehicleListingMapper.mapToResponse(vehicleListing);
			responseList.add(response);
		}

		return responseList;
	}
	public void addLocationToListing(int listingId, int locationId) {
		VehicleListing vehicleListing = vehicleListingRepository.findById(listingId)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle listing not found"));

		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new LocationNotFoundException("Location not found"));
		
		if (!vehicleListing.getLocations().contains(location)) {
			vehicleListing.getLocations().add(location);
		}

		vehicleListing = vehicleListingRepository.save(vehicleListing);

	}
}
