package com.bookmyflight.booktickets;

import java.util.ArrayList;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public class BookTicketsController implements BookTicketsControllerCallBack,BookTicketsModelControllerCallBack{
	private BookTicketsViewCallBack bookTicketsView;
	private BookTicketsModelCallBack bookTicketsModel;
	public BookTicketsController(BookTicketsViewCallBack bookTicketsView) {
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
		if(option==(flights.size())+1) {
			bookTicketsView.callBackToManageTicket();
		}
		bookTicketsView.bookFlight(flights.get(option-1));
	}
	@Override
	public void addPassengersDetails(List<Passenger> passengerList,Flight flight,char classChosen) {
		List<Ticket> ticketList = new ArrayList<>();
		for(Passenger p:passengerList) {
			flight.setSeatCapacity(flight.getSeatCapacity()-1);
			if(classChosen=='E' && flight.getEconomySeatCount()>0) {
				flight.setEconomySeatCount(flight.getEconomySeatCount()-1);
				flight.setClassChosen(classChosen);
			}
			else if(classChosen =='B' && flight.getBusinessSeatCount()>0){
				flight.setBusinessSeatCount(flight.getBusinessSeatCount()-1);
				flight.setClassChosen(classChosen);
			}
			else {
				bookTicketsView.flightsEmpty("There isn't enough seat in "+classChosen+" class");
			}
			ticketList.add(new Ticket(p,flight));
		}
		bookTicketsModel.bookFlightWithPassenger(ticketList);
	}

	@Override
	public void ticketBookedSuccessfully(List<Ticket> ticketList) {
		bookTicketsView.ticketBookedSuccessfully(ticketList);
	}

	@Override
	public String getSeatforChosenFlight(char classChosen, Flight flight) {
		if(classChosen=='B')
			return ""+flight.getBusinessSeatCount();
		else 
			return ""+flight.getEconomySeatCount();
	}

	@Override
	public String getPriceforChosenFlight(char classChosen, Flight flight) {
		if(classChosen=='B')
			return ""+flight.getPrice()*2;
		else
			return ""+flight.getPrice();
	}

	@Override
	public String getFlightDestinationOnDate(String date) {
		String result ="";
		List<Flight> flightData = bookTicketsModel.getFlightDataOnDate(date);
		if(flightData.isEmpty())
			return result = "No Flights Found for this date";
		for(Flight f: flightData) {
			result = result+"\nFlight Name:"+f.getFlightNo()+"\tBoarding:"+f.getOrigin().toUpperCase()+"\tDestination:"+f.getDestination().toUpperCase();
		}
		return result;
		
	}

}
