package com.bookmyflight.cancelTickets;

import java.util.List;
import java.util.Scanner;

import com.bookmyflight.dto.Ticket;
import com.bookmyflight.managetickets.ManageTicketView;

public class CancelTicketView implements CancelTicketViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private CancelTicketControllerCallBack cancelTicketController;
	private ManageTicketView manageTicketView;
	public CancelTicketView() {
		this.cancelTicketController = new CancelTicketController(this);
	}
	public void showTicketsToCancel(ManageTicketView manageTicketView) {
		this.manageTicketView = manageTicketView;
		cancelTicketController.ticketsToCancel();
	}
	public void bookedTickets(List<Ticket> ticketList) {
		System.out.println("Showing booked tickets");
		int sno=1;
		for(Ticket ticket:ticketList) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(sno+ ")Ticket ID "+ticket.getTicketID()+"\nFlight: "+ticket.getFlight().getFlightNo()+"\t\tSeat No:"+ticket.getSeatNo());
			System.out.println("Passenger Name: "+ticket.getPassenger().getName()+"\tPassenger Age: "+ticket.getPassenger().getAge());
			System.out.println("Boarding date is " + ticket.getFlight().getDate()+"\t Journey duration "+ticket.getFlight().getDuration()+"hrs");
			System.out.println("-----------------------------------------------------------------");
			sno++;
		}
		System.out.println("Press "+(ticketList.size()+1)+" to go back");
		System.out.println("Select one option to cancel the ticket");
		int option = scanner.nextInt();
		cancelTicketController.cancelTicketOption(option,ticketList);
	}
	@Override
	public void callBackToManageTicket() {
		manageTicketView.bookTickets();
	}
	@Override
	public void noTicketsBooked(String error) {
		System.out.println(error);
		callBackToManageTicket();
	}
}
