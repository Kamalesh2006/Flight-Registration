package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;

public interface BookTicketsViewCallBack {

	void printFlights(List<Flight> flights);

	void bookFlight(Flight flight);

}
