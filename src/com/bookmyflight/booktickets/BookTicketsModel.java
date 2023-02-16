package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;
import com.bookmyflight.repository.FlightDB;

public class BookTicketsModel implements BookTicketsModelCallBack{
	private BookTicketsModelControllerCallBack bookTicketsModelControllerCallBack;
	private FlightDB flightDB = FlightDB.getInstance();
	public BookTicketsModel(BookTicketsController bookTicketsController) {
		this.bookTicketsModelControllerCallBack = bookTicketsController;
	}
	@Override
	public void showFlightsOnDate(String departureCity, String destinationCity,String date) {
		List<Flight> result = flightDB.getFlightsOnDate(departureCity,destinationCity,date);
		bookTicketsModelControllerCallBack.flightsOnDate(result);
	}
	@Override
	public void bookFlightWithPassenger(List<Ticket> ticketList) {
		flightDB.addTickets(ticketList);
		bookTicketsModelControllerCallBack.ticketBookedSuccessfully(ticketList);
	}

}
