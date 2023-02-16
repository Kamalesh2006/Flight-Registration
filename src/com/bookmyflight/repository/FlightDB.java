package com.bookmyflight.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bookmyflight.dto.Flight;

public class FlightDB {
	private static FlightDB flightInstance;
	private List<Flight> flightsDB = new ArrayList<>();
	private FlightDB() {
		
		//default available flights in database
		flightsDB.add(new Flight("Boeing-614","chennai","bengaluru","01:00pm","02:00pm","1:00",8000,"01/03/2023",120));
		flightsDB.add(new Flight("AirAsia-001","Chennai","NewDelhi","03:00pm","06:30pm","3:30",21600,"01/03/2023",160));
		flightsDB.add(new Flight("IndiGo-6E-6012","Bengaluru","Chennai","06:00am","7:00am","1:00",7000,"02/03/2023",200));
		flightsDB.add(new Flight("Vistara-UK-866","Chennai","Dubai","7:00pm","01:00am","6:00",33000,"01/03/2023",280));
		
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
	public Set<String> getDestinationInDB() {
		Set<String> result=new HashSet<>();
		for(Flight f:flightsDB) {
			result.add(f.getDepartureTime());
		}
		return result;
	}
	
}
