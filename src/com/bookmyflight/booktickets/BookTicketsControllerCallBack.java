package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;

public interface BookTicketsControllerCallBack {

	
	void showAvailableFlights(String date, String departureCity, String destinationCity);


	void showAvailableFlightsOnDate(String departureCity, String destinationCity,String date);


	void selectedFlight(int option, List<Flight> flights);


	void addPassengersDetails(List<Passenger> passengerList, Flight flight, char classChosen);


	String getSeatforChosenFlight(char classChosen, Flight flight);


	String getPriceforChosenFlight(char classChosen, Flight flight);


	String getFlightDestinationOnDate(String date);


}
