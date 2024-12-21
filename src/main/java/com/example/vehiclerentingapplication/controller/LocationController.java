package com.example.vehiclerentingapplication.controller;

import com.example.vehiclerentingapplication.service.LocationService;
import com.example.vehiclerentingapplication.util.ResponseStructure;
import com.example.vehiclerentingapplication.request.LocationRequest;
import com.example.vehiclerentingapplication.response.LocationResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/locations/add")
    public  ResponseEntity<ResponseStructure<LocationResponse>> addLocation(@RequestBody LocationRequest locationRequest) {
        LocationResponse locationResponse = locationService.addLocation(locationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "Location Added Succsesfully", locationResponse));

    }

    @GetMapping("/locations/all")
    public  ResponseEntity<ResponseStructure<List<LocationResponse>>> getAllLocations() {
        List<LocationResponse> locations = locationService.getAllLocations();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "Location/Locations Found Succsesfully", locations));
    }
    @GetMapping("/locations/by-listing")
    public ResponseEntity<ResponseStructure<List<LocationResponse>>> getLocationsByVehicleListingId(
            @RequestParam("listingId") int listingId) {
        List<LocationResponse> responses = locationService.getLocationsByVehicleListingId(listingId);
        return ResponseEntity.ok(ResponseStructure.create(HttpStatus.OK.value(), "Locations Retrieved Successfully", responses));
    }
    
}