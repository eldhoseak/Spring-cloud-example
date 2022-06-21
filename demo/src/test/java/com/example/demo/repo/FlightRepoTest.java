package com.example.demo.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entities.FlightEntity;
import com.example.demo.repository.FlightRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepoTest {
	
	@Autowired
	private FlightRepository  repo;
	
	
	@Test
	public void testFlightRepo() {
		FlightEntity entity = new FlightEntity();
		entity.setFlightName("AA01A");
		entity.setFrom("COK");
		entity.setTo("LHR");
		
		repo.save(entity);
		
		Optional<FlightEntity> flightData = repo.findById("AA01A");
		assertEquals("AA01A", flightData.get().getFlightName());		
		
	}
	

}
