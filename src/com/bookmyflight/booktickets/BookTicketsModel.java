package com.bookmyflight.booktickets;

import java.time.LocalDate;
import java.util.ArrayList;
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
	public void showFlightsOnDate(String departureCity, String destinationCity,LocalDate date) {
		List<Flight> flightList = flightDB.getFlightsInDB();
		List<Flight> result  = new ArrayList<>();
		for(Flight f: flightList) {
			if (f.getDate().equals(date) && f.getDestination().equals(destinationCity) && f.getOrigin().equals(departureCity))
				result.add(f);
		}
		bookTicketsModelControllerCallBack.flightsOnDate(result,departureCity,destinationCity);
	}
	@Override
	public void bookFlightWithPassenger(List<Ticket> ticketList) {
		flightDB.addTickets(ticketList);
		bookTicketsModelControllerCallBack.ticketBookedSuccessfully(ticketList);
	}
	@Override
	public List<Flight> getFlightDataOnDate(LocalDate date) {
		List<Flight> flightList = flightDB.getFlightsInDB();
		List<Flight> result  = new ArrayList<>();
		for(Flight f: flightList) {
			if(f.getDate().isEqual(date)) {
				result.add(f);
			}
		}
		return result;
	}

}
