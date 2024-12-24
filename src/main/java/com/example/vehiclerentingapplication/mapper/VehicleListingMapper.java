package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.request.VehicleListingRequest;
import com.example.vehiclerentingapplication.response.VehicleListingResponse;

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
		return response;
	}
}
