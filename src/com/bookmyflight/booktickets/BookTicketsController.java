package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;

public class BookTicketsController implements BookTicketsControllerCallBack,BookTicketsModelControllerCallBack{
	private BookTicketsViewCallBack bookTicketsView;
	private BookTicketsModelCallBack bookTicketsModel;
	public BookTicketsController(BookTicketsView bookTicketsView) {
		this.bookTicketsView=bookTicketsView;
		bookTicketsModel=new BookTicketsModel(this);
	}
	
	@Override
	public void showAvailableFlightsOnDate(String departureCity,String destinationCity,String date) {
		bookTicketsModel.showFlightsOnDate(departureCity,destinationCity,date);
	}
	@Override
	public void flightsOnDate(List<Flight> result) {
		if(!result.isEmpty())
			bookTicketsView.printFlights(result);
		else {
			bookTicketsView.flightsEmpty("No flights found for the respective date and location");
		}
	}
	@Override
	public void showAvailableFlights(String departureCity, String destinationCity,String date) {
		bookTicketsModel.showFlightsOnDate(departureCity, destinationCity,date);
	}
	@Override
	public void selectedFlight(int option, List<Flight> flights) {
		if(option==flights.size()+1) {
			
		}
		bookTicketsView.bookFlight(flights.get(option-1));
	}
	@Override
	public void passengerAddedSuccessfully(String email) {
		bookTicketsView.passengerAddedSuccessfull(email);
	}

	@Override
	public void addPassengersDetails(List<Passenger> passengerList,Flight flight) {
		
	}

}
