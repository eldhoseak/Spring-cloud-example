package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, String>{
	
	public Optional<FlightEntity> findByFrom (String frm);

}
