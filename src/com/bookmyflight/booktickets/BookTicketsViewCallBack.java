package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;
import com.bookmyflight.managetickets.ManageTicketView;

public interface BookTicketsViewCallBack {
	void selectFlightToBook(ManageTicketView manageTicketView);

	void printFlights(List<Flight> flights);

	void bookFlight(Flight flight);

	void flightsEmpty(String string);

	void ticketBookedSuccessfully(List<Ticket> ticketList);

	void callBackToManageTicket();

	void callToTatkalTicket(String string);

}
