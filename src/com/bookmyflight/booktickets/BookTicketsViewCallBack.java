package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Ticket;

public interface BookTicketsViewCallBack {
	void selectFlightToBook();

	void printFlights(List<Flight> flights);

	void bookFlight(Flight flight);

	void flightsEmpty(String string);

	void ticketBookedSuccessfully(List<Ticket> ticketList);

}
