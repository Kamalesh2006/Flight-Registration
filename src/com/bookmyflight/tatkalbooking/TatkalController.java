package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public class TatkalController implements TatkalControllerCallBack,TatkalModelControllerCallBack{
	private TatkalViewCallBack tatkalView;
	private TatkalModelCallBack tatkalModel;
	public TatkalController(TatkalView tatkalView) {
		this.tatkalView = tatkalView;
		tatkalModel = new TatkalModel(this);
	}
	@Override
	public void obtainedFlightDetails(List<Flight> flightDetails,LocalDate date,String departureCity,String destinationCity) {
		List<Flight> nextDayFlight = new ArrayList<>();
		for(Flight f: flightDetails) {
			if(f.getDate().isEqual(date) && f.getOrigin().equals(departureCity) && f.getDestination().equals(destinationCity)) {
				int flightDepartureHour = f.getDepartureTime().getHour();
				int hourNow = LocalTime.now().getHour();
				
				//showing the tatkal seats
				int seats = f.getSeatCapacity()+f.getTatkalSeatCount();
				f.setSeatCapacity(seats);
				//increasing the price of the flight ticket based on hours remaining
				int diff =  5+ (hourNow - flightDepartureHour)/10;
				
				f.setPrice(f.getPrice()*diff);
				nextDayFlight.add(f);
			}
		}
		tatkalView.nextDayFlight(nextDayFlight,date);
	}
	@Override
	public void decideTatkalFlight(int option, List<Flight> nextDayFlight) {
		tatkalView.bookTatkalFlight(nextDayFlight.get(option-1));
	}
	@Override
	public void bookTatkalTicket(Flight flight, List<Passenger> passengerList) {
		if(flight.getSeatCapacity()>passengerList.size()) {
			flight.setSeatCapacity(flight.getSeatCapacity()-passengerList.size());
			List<Ticket> ticketsBooked = new ArrayList<>();
			for(Passenger p: passengerList) {
				ticketsBooked.add(new Ticket(p,flight));
			}
			tatkalView.tatkalBookedSuccessfully(flight,passengerList,ticketsBooked);
		}
		else {
			tatkalView.insufficientTatkalSeat(flight,passengerList);
		}
	}
	@Override
	public void getFlightsOnDate(LocalDate date, String departureCity, String destinationCity) {
		tatkalModel.getFlightsOnNextDay(date.plusDays(1),departureCity,destinationCity);
	}
}
