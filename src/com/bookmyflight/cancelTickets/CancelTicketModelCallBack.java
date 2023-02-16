package com.bookmyflight.cancelTickets;

import com.bookmyflight.dto.Ticket;

public interface CancelTicketModelCallBack {

	void getTicketsBooked();

	void cancelTicket(Ticket ticket);

}
