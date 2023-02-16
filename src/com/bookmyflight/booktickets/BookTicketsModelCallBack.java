package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public interface BookTicketsModelCallBack {


	void showFlightsOnDate(String departureCity, String destinationCity, String date);

	void bookFlightWithPassenger(List<Ticket> ticketList);

}
