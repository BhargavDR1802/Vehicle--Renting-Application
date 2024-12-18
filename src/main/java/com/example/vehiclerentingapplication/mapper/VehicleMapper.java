package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.response.VehicleResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {

    public VehicleResponse mapToResponse(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        response.setVehicleId(vehicle.getVehicleId());
        response.setBrand(vehicle.getBrand());
        response.setModel(vehicle.getModel());
        response.setVehicleType(vehicle.getVehicleType().name());
        response.setFuelType(vehicle.getFuelType().name());

        // Collecting image IDs for the response
        if (vehicle.getVehicleImages() != null) {
            List<Integer> imageIds = vehicle.getVehicleImages().stream()
                    .map(Image::getImageId)  // Retrieve the image ID
                    .collect(Collectors.toList());
            response.setImageIds(imageIds);  // Set the image IDs in the response
        }

        return response;
    }

    public List<VehicleResponse> mapToResponseList(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::mapToResponse).collect(Collectors.toList());
    }
}
