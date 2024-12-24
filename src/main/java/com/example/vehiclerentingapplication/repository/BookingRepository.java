package com.example.vehiclerentingapplication.repository;

import com.example.vehiclerentingapplication.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
