package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;

public interface TatkalControllerCallBack {

	void getFlightsOnDate(LocalDate date, String departureCity, String destinationCity);

	void decideTatkalFlight(int option, List<Flight> nextDayFlight);

	void bookTatkalTicket(Flight flight, List<Passenger> passengerList);

}
