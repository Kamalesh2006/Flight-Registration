package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;

public interface BookTicketsControllerCallBack {

	void passengerDetails(String name, int age, char gender,  String email,long phoneNo);


	void showAvailableFlights(String date, String departureCity, String destinationCity);


	void showAvailableFlightsOnDate(String departureCity, String destinationCity, String date);


	void selectedFlight(int option, List<Flight> flights);

}
