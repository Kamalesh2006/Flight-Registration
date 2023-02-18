package com.bookmyflight.booktickets;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;

public interface BookTicketsControllerCallBack {


	void showAvailableFlightsOnDate(String departureCity, String destinationCity,LocalDate date);


	void selectedFlight(int option, List<Flight> flights);


	void addPassengersDetails(List<Passenger> passengerList, Flight flight, char classChosen);


	String getSeatforChosenFlight(char classChosen, Flight flight);


	String getPriceforChosenFlight(char classChosen, Flight flight);


	String getFlightDestinationOnDate(LocalDate date);



}
