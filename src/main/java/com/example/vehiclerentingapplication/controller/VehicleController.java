package com.example.vehiclerentingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vehiclerentingapplication.enums.VehicleType;
import com.example.vehiclerentingapplication.request.VehicleRequest;
import com.example.vehiclerentingapplication.response.VehicleResponse;
import com.example.vehiclerentingapplication.service.VehicleService;
import com.example.vehiclerentingapplication.util.ResponseStructure;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle/register")
    public ResponseEntity<ResponseStructure<VehicleResponse>> registerVehicle(
            @RequestParam("vehicleType") VehicleType vehicleType, 
            @RequestBody VehicleRequest request) {
        VehicleResponse response = vehicleService.register(request, vehicleType);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), vehicleType + " Vehicle Created", response));
    }

    @GetMapping("/vehicles")
    public ResponseEntity<ResponseStructure<List<VehicleResponse>>> findAllVehicles() {
        List<VehicleResponse> vehicleResponses = vehicleService.findAllVehicles();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseStructure.create(HttpStatus.OK.value(), "All Vehicles Found", vehicleResponses));
    }

    @PutMapping("/update/vehicle")
    public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@RequestParam("vehicleId") int vehicleId,
            @RequestBody VehicleRequest request) {
        VehicleResponse response = vehicleService.updateVehicleById(vehicleId, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Updated Successfully", response));
    }
}
