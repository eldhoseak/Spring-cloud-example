package com.example.demo.model;

public class FlightDto {
	
	private String flightName;
	private String from;
	private String to;
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "FlightDto [flightName=" + flightName + ", from=" + from + ", to=" + to + "]";
	}

}
