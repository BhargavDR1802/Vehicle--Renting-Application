package com.example.vehiclerentingapplication.request;

import com.example.vehiclerentingapplication.enums.FuelType;
import com.example.vehiclerentingapplication.enums.VehicleType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class VehicleRequest {

    private String brand;
    private String model;
    private VehicleType vehicleType;
    private FuelType fuelType;
    private List<MultipartFile> vehicleImages;  
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public List<MultipartFile> getVehicleImages() {
        return vehicleImages;
    }

    public void setVehicleImages(List<MultipartFile> vehicleImages) {
        this.vehicleImages = vehicleImages;
    }
}
