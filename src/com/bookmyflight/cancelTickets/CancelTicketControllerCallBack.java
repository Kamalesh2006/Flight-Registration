package com.bookmyflight.cancelTickets;

import java.util.List;

import com.bookmyflight.dto.Ticket;

public interface CancelTicketControllerCallBack {

	void ticketsToCancel();

	void cancelTicketOption(int option, List<Ticket> ticketList);

}
