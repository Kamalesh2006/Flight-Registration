package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Ticket;

public interface BookTicketsModelControllerCallBack {

	void flightsOnDate(List<Flight> result, String departureCity, String destinationCity);

	void ticketBookedSuccessfully(List<Ticket> ticketList);

}
