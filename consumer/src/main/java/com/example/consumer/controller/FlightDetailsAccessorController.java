package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FlightDto;

@RestController
public class FlightDetailsAccessorController {


	@Autowired
	com.example.consumer.service.ConsumerService service;
	
	
	@GetMapping("/getFlightDetails")
	public FlightDto getFlights() {
		
		return service.getFlightDetails();
		
	}

}
