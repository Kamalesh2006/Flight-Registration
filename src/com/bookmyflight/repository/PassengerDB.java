package com.bookmyflight.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmyflight.dto.Passenger;

public class PassengerDB {
	private List<Passenger> passengerDB = new ArrayList<>();
	private static PassengerDB passengerInstance;
	private PassengerDB() {
		
	}
	public static PassengerDB getInstance() {
		if(passengerInstance==null) {
			passengerInstance = new PassengerDB();
		}
		return passengerInstance;
	}
	public void addPassenger(String name, int age, char gender, long phoneNo, String email) {
		passengerDB.add(new Passenger(name,age,gender,email,phoneNo));
	}
}
