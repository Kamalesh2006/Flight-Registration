package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;

public class BookTicketsController implements BookTicketsControllerCallBack,BookTicketsModelControllerCallBack{
	private BookTicketsViewCallBack bookTicketsView;
	private BookTicketsModelCallBack bookTicketsModel;
	public BookTicketsController(BookTicketsView bookTicketsView) {
		this.bookTicketsView=bookTicketsView;
		bookTicketsModel=new BookTicketsModel(this);
	}
	@Override
	public void passengerDetails(String name, int age, char gender, String email,long phoneNo) {
		bookTicketsModel.addPassengersToDB(name,age,gender,email,phoneNo);
	}
	@Override
	public void showAvailableFlightsOnDate(String departureCity,String destinationCity,String date) {
		bookTicketsModel.showFlightsOnDate(departureCity,destinationCity,date);
	}
	@Override
	public void flightsOnDate(List<Flight> result) {
		bookTicketsView.printFlights(result);
	}
	@Override
	public void showAvailableFlights(String date, String departureCity, String destinationCity) {
		bookTicketsModel.showFlightsOnDate(date, destinationCity, date);
	}
	@Override
	public void selectedFlight(int option, List<Flight> flights) {
		bookTicketsView.bookFlight(flights.get(option-1));
	}

}
