package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.FlightDto;

@FeignClient( name ="FLIGHT-SERVICE",  fallback = ConsumerService.ConsumerServiceFallback.class)
public interface ConsumerService {

	
	@RequestMapping(value = "/flight/getFlightDetails/QAA071", method = RequestMethod.GET)
	public  FlightDto getFlightDetails() ;

	 @Component
	    public class ConsumerServiceFallback implements ConsumerService {
	 
	        public   FlightDto getFlightDetails() {
	        	System.out.println("Get in fall back");
	        	return null;
	        }
	    }
}