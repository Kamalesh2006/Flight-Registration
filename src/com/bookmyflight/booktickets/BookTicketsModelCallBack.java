package com.bookmyflight.booktickets;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public interface BookTicketsModelCallBack {


	void showFlightsOnDate(String departureCity, String destinationCity, LocalDate date);

	void bookFlightWithPassenger(List<Ticket> ticketList);

	List<Flight> getFlightDataOnDate(LocalDate date);

}
