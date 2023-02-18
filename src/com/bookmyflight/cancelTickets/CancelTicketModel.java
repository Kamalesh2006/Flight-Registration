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
		List<Ticket> ticketTable = flightInstance.getTickets();
		char classChosen = ticket.getFlight().getClassChosen();
		if(classChosen=='B') {
			ticket.getFlight().setBusinessSeatCount(ticket.getFlight().getBusinessSeatCount()+1);
		}
		else {
			ticket.getFlight().setEconomySeatCount(ticket.getFlight().getEconomySeatCount()+1);
		}
		int seatNo= ticket.getSeatNoInt();
		int[] seatArr = ticket.getFlight().getSeats();
		seatArr[seatNo-1]=0;
		ticket.getFlight().setSeats(seatArr);
		ticket.getFlight().setSeatCapacity(ticket.getFlight().getSeatCapacity()+1);
		ticketTable.remove(ticket);
		cancelTicketController.cancelledSuccessfully();
	}

}
