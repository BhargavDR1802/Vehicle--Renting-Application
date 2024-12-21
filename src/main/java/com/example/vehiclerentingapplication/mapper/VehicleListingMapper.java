package com.example.vehiclerentingapplication.mapper;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.request.VehicleListingRequest;
import com.example.vehiclerentingapplication.response.VehicleListingResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VehicleListingMapper {

	public VehicleListing mapToListing(VehicleListingRequest request) {
		VehicleListing vehicleListing = new VehicleListing();
		vehicleListing.setVehicleNo(request.getVehicleNo());
		vehicleListing.setPricePerDay(request.getPricePerDay());
		vehicleListing.setSeating(request.getSeating());
		return vehicleListing;
	}


	public VehicleListingResponse mapToResponse(VehicleListing vehicleListing) {
		VehicleListingResponse response = new VehicleListingResponse();
		response.setListingId(vehicleListing.getListingId());
		response.setVehicleNo(vehicleListing.getVehicleNo());
		response.setPricePerDay(vehicleListing.getPricePerDay());
		response.setSeating(vehicleListing.getSeating());
		List<Integer> locationIds = new ArrayList<>();
		for (Location location : vehicleListing.getLocations()) {
			locationIds.add(location.getLocationId());
		}
		response.setLocationIds(locationIds);

		return response;
	}
}
