package com.example.vehiclerentingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentingapplication.entity.VehicleListing;

public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {

}
