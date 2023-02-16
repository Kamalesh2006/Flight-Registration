package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Ticket;

public interface BookTicketsModelControllerCallBack {

	void flightsOnDate(List<Flight> result);

	void ticketBookedSuccessfully(List<Ticket> ticketList);

}
