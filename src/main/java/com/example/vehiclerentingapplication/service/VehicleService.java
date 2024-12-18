package com.example.vehiclerentingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.enums.VehicleType;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.request.VehicleRequest;
import com.example.vehiclerentingapplication.response.VehicleResponse;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.mapper.VehicleMapper;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.service.ImageService;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final ImageService imageService;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, ImageService imageService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.imageService = imageService;
    }

    public VehicleResponse registerVehicle(VehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setVehicleType(request.getVehicleType());
        vehicle.setFuelType(request.getFuelType());
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.mapToResponse(savedVehicle);
    }

    public List<VehicleResponse> findAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) {
            throw new VehicleNotFoundException("No Vehicles present");
        }
        return vehicleMapper.mapToResponseList(vehicles);
    }

    public VehicleResponse updateVehicleById(int vehicleId, VehicleRequest request) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));

        existingVehicle.setBrand(request.getBrand());
        existingVehicle.setModel(request.getModel());
        existingVehicle.setFuelType(request.getFuelType());
        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

        return vehicleMapper.mapToResponse(updatedVehicle);
    }
}
