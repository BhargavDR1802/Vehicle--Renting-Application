package com.example.vehiclerentingapplication.service;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.mapper.VehicleListingMapper;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.request.VehicleListingRequest;
import com.example.vehiclerentingapplication.response.VehicleListingResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleListingService {

	private VehicleListingRepository vehicleListingRepository;

	private VehicleRepository vehicleRepository;

	private VehicleListingMapper vehicleListingMapper;

	private final AuthUtil authUtil;




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

}
