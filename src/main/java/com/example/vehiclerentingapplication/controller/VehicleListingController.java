package com.example.vehiclerentingapplication.controller;

import com.example.vehiclerentingapplication.request.VehicleListingRequest;
import com.example.vehiclerentingapplication.response.VehicleListingResponse;
import com.example.vehiclerentingapplication.service.VehicleListingService;
import com.example.vehiclerentingapplication.util.ResponseStructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleListingController {

    @Autowired
    private VehicleListingService vehicleListingService;

    @PreAuthorize("hasAuthority('RENTING_PARTNER')")
    @PostMapping("/register/listing")
    public ResponseEntity<ResponseStructure<VehicleListingResponse>> createVehicleListing(@RequestBody VehicleListingRequest request,
    		@RequestParam("vehicleId") int vehicleId) {
        VehicleListingResponse response = vehicleListingService.createVehicleListing(request, vehicleId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Added Succsesfully", response));
    }

    @GetMapping("all/listing")
    public ResponseEntity<ResponseStructure<List<VehicleListingResponse>>> getAllVehicleListings() {
        List<VehicleListingResponse> response= vehicleListingService.getAllVehicleListings();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "All Vehicles Found Successfully", response));
    }
}
