package com.example.vehiclerentingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentingapplication.entity.Drop_Entity;

public interface DropRepository extends JpaRepository<Drop_Entity, Integer> {

}
