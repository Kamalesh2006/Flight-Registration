package com.bookmyflight.cancelTickets;

import java.util.List;
import java.util.Scanner;

import com.bookmyflight.dto.Ticket;

public class CancelTicketView implements CancelTicketViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private CancelTicketControllerCallBack cancelTicketController;
	public CancelTicketView() {
		this.cancelTicketController = new CancelTicketController(this);
	}
	public void showTicketsToCancel() {
		cancelTicketController.ticketsToCancel();
	}
	public void bookedTickets(List<Ticket> ticketList) {
		System.out.println("Showing booked tickets");
		int sno=1;
		for(Ticket ticket:ticketList) {
			System.out.println("Press "+sno+" "+ticket.getTicketID()+" "+ticket.getPassenger().getName()+" "+ticket.getFlight().getFlightNo()+" "+ticket.getFlight().getDestination());
			sno++;
		}
		System.out.println("Select one option to cancel the ticket");
		
	}
}
