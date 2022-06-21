package com.example.demo.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.FlightEntity;
import com.example.demo.model.FlightDto;
import com.example.demo.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository repo;

	public FlightDto getFlightDetails(String flightName) throws Exception {

		Optional<FlightEntity> flightEntity = repo.findById(flightName);

		if (flightEntity.isPresent()) {
			FlightDto dto = new FlightDto();
			dto.setFlightName(flightName);
			dto.setFrom(flightEntity.get().getFrom());
			dto.setTo(flightEntity.get().getTo());
			return dto;
		}

		throw new Exception("Flight not found");
	}

	public boolean saveData(FlightDto dto) {

		FlightEntity entity = new FlightEntity();
		entity.setFlightName(dto.getFlightName());
		entity.setFrom(dto.getFrom());
		entity.setTo(dto.getTo());

		repo.save(entity);
		LoggerFactory.getLogger(getClass()).info("Successfully saved ");
		return true;
	}

}
