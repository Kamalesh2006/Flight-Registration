package com.bookmyflight.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmyflight.dto.Flight;

public class FlightDB {
	private static FlightDB flightInstance;
	private List<Flight> flightsDB = new ArrayList<>();
	private FlightDB() {
		
	}
	public static FlightDB getInstance() {
		if(flightInstance==null) {
			flightInstance = new FlightDB();
		}
		return flightInstance;
	}
	public List<Flight> getFlightsInDB(){
		return flightsDB;
	}
	
}
