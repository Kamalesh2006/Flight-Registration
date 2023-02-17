package com.bookmyflight.cancelTickets;

import java.util.List;

import com.bookmyflight.dto.Ticket;

public class CancelTicketController implements CancelTicketControllerCallBack,CancelTicketModelControllerCallBack{
	private CancelTicketViewCallBack cancelTicketView;
	private CancelTicketModelCallBack cancelTicketModel;
	public CancelTicketController(CancelTicketView cancelTicketView) {
		this.cancelTicketView = cancelTicketView;
		cancelTicketModel = new CancelTicketModel(this);
	}
	@Override
	public void ticketsToCancel() {
		cancelTicketModel.getTicketsBooked();
	}
	@Override
	public void retrievedBookedTickets(List<Ticket> ticketList) {
		if(ticketList.isEmpty()) {
			cancelTicketView.noTicketsBooked("No tickets Booked so far");
		}
		cancelTicketView.bookedTickets(ticketList);
	}
	@Override
	public void cancelTicketOption(int option, List<Ticket> ticketList) {
		if(option==ticketList.size()+1)
			cancelTicketView.callBackToManageTicket();
		Ticket ticket = ticketList.remove(option-1);
		cancelTicketModel.cancelTicket(ticket);
		if(ticketList.isEmpty()) {
			cancelTicketView.callBackToManageTicket();
		}
		cancelTicketView.bookedTickets(ticketList);
	}

}
