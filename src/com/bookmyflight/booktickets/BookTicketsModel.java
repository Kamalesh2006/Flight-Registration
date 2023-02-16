package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.repository.FlightDB;
import com.bookmyflight.repository.PassengerDB;

public class BookTicketsModel implements BookTicketsModelCallBack{
	private BookTicketsModelControllerCallBack bookTicketsModelControllerCallBack;
	private PassengerDB passengerDB = PassengerDB.getInstance();
	private FlightDB flightDB = FlightDB.getInstance();
	public BookTicketsModel(BookTicketsController bookTicketsController) {
		this.bookTicketsModelControllerCallBack = bookTicketsController;
	}
	@Override
	public void addPassengersToDB(String name, int age, char gender,String email,long phoneNo){
		passengerDB.addPassenger(name, age, gender, phoneNo, email);

	}
	@Override
	public void showFlightsOnDate(String departureCity, String destinationCity, String date) {
		List<Flight> result = flightDB.getFlightsOnDate(departureCity,destinationCity,date);
		bookTicketsModelControllerCallBack.flightsOnDate(result);
	}

}
