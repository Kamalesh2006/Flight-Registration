package com.bookmyflight.cancelTickets;

import java.util.List;

import com.bookmyflight.dto.Ticket;
import com.bookmyflight.repository.FlightDB;

public class CancelTicketModel implements CancelTicketModelCallBack {
	private CancelTicketModelControllerCallBack cancelTicketController;
	private FlightDB flightInstance = FlightDB.getInstance();
	public CancelTicketModel(CancelTicketController cancelTicketController) {
		this.cancelTicketController = cancelTicketController;
	}
	@Override
	public void getTicketsBooked() {
		List<Ticket> ticketList = flightInstance.getTickets();
		cancelTicketController.retrievedBookedTickets(ticketList);
	}
	@Override
	public void cancelTicket(Ticket ticket) {
		flightInstance.deleteTicket(ticket);
	}

}
