package com.bookmyflight.cancelTickets;

import java.util.List;

import com.bookmyflight.dto.Ticket;

public interface CancelTicketViewCallBack {

	void bookedTickets(List<Ticket> ticketList);

	void callBackToManageTicket();

	void noTicketsBooked(String string);

	void successfullyCancelled();

}
