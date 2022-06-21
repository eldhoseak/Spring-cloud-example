package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FlightDto;
import com.example.demo.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/getFlightDetails/{flightName}")
	public FlightDto getFlightDetails(@PathVariable String flightName) throws Exception {

		FlightDto dto = flightService.getFlightDetails(flightName);
		return dto;

	}
	
	@GetMapping("/hello")
	public  String getGreetings() {
		return "Hello";
	}
	
	@GetMapping("/getFlightDetailssample")
	public FlightDto getFlightDetails() throws Exception {

		FlightDto dto = flightService.getFlightDetails("QAA071");
		return dto;

	}
	
	@PostMapping("/saveFlightDetails")
	public String saveData(@RequestBody FlightDto dto) {
		LoggerFactory.getLogger(getClass()).info("Flight details " + dto);
		flightService.saveData(dto);
	
		return "saved";
	}

}
