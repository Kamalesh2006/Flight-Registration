package com.bookmyflight.cancelTickets;

import java.util.List;

import com.bookmyflight.dto.Ticket;

public interface CancelTicketModelControllerCallBack {

	void retrievedBookedTickets(List<Ticket> ticketList);

	void cancelledSuccessfully();

}
