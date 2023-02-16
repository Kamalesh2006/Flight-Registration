package com.bookmyflight.dto;

public class Ticket {
	private Passenger passenger;
	private Flight flight;
	private String ticketID;
	public Ticket(Passenger passenger, Flight flight) {
		super();
		this.passenger = passenger;
		this.flight = flight;
		this.setTicketID(passenger.getEmail()+flight.getFlightNo());
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getTicketID() {
		return ticketID;
	}
	private void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	
}
