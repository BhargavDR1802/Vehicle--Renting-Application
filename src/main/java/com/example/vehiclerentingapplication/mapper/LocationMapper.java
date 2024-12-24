package com.example.vehiclerentingapplication.mapper;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.request.LocationRequest;
import com.example.vehiclerentingapplication.response.LocationResponse;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public Location toLocation(LocationRequest request) {
        Location location = new Location();
        location.setAddressLine(request.getAddressLine());
        location.setAddressLineOptional(request.getAddressLineOptional());
        location.setArea(request.getArea());
        location.setCity(request.getCity());
        location.setState(request.getState());
        location.setCountry(request.getCountry());
        location.setPincode(request.getPincode());
        location.setPhoneNumber(request.getPhoneNumber());
        return location;
    }

    public LocationResponse toResponse(Location location) {
        LocationResponse response = new LocationResponse();
        response.setLocationId(location.getLocationId());
        response.setAddressLine(location.getAddressLine());
        response.setAddressLineOptional(location.getAddressLineOptional());
        response.setArea(location.getArea());
        response.setCity(location.getCity());
        response.setState(location.getState());
        response.setCountry(location.getCountry());
        response.setPincode(location.getPincode());
        response.setPhoneNumber(location.getPhoneNumber());
        return response;
    }
}