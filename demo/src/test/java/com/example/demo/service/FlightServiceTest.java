package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entities.FlightEntity;
import com.example.demo.model.FlightDto;
import com.example.demo.repository.FlightRepository;

@ExtendWith(SpringExtension.class)
public class FlightServiceTest {

	@Autowired
	FlightService flightService;

	@MockBean
	FlightRepository repo;

	@TestConfiguration
	static class FlightServiceTestConfiuration {

		@Bean
		public FlightService createFlightService() {
			return new FlightService();
		}
	}

	@Test
	public void testGetFlightDetails() throws Exception {

		FlightEntity entity = new FlightEntity();
		entity.setFlightName("A001A");
		when(repo.findById(Mockito.anyString())).thenReturn(Optional.of(entity));
		FlightDto flightDto = flightService.getFlightDetails("A001A");
		assertEquals("A001A", flightDto.getFlightName());
	}

}
