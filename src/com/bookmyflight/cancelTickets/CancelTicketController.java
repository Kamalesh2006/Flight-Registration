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
		cancelTicketView.bookedTickets(ticketList);
	}

}
