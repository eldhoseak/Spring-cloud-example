package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.FlightDto;
import com.example.demo.service.FlightService;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {
	
	@MockBean
	FlightService flightService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetFlightDetails() throws Exception {
		
		FlightDto dto = new FlightDto();
		dto.setFlightName("AA01A");
		
		when(flightService.getFlightDetails(Mockito.anyString())).thenReturn(dto);

		mvc.perform(get("/getFlightDetails/AA01A")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andExpect(content().string("{\"flightName\":\"AA01A\",\"from\":null,\"to\":null}"));
	}
	
	
	@Test
	public void testSaveData() throws Exception {
		
		String flightJson = "{\r\n"
				+ "    \"flightName\": \"QAA071\",\r\n"
				+ "    \"from\": \"COK\",\r\n"
				+ "    \"to\": \"DUB\"\r\n"
				+ "}";
		
		when(flightService.saveData(Mockito.any())).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				                           .post("/saveFlightDetails")
				                           .content(flightJson)
				                           .contentType("application/json");
		
		
		mvc.perform(requestBuilder).andDo(print()).andExpect(status().isCreated()).andExpect(content().string("Saved!"));
		
	}
	
	

}
