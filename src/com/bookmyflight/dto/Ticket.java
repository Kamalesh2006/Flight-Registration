package com.bookmyflight.dto;

public class Ticket {
	private Passenger passenger;
	private Flight flight;
	private String ticketID;
	private String seatNo;
	private int seatNoInt;
	
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Flight flight,char classChosen) {
		int i = classChosen=='B'?0:flight.getBusinessSeatCount();
		int length = flight.getSeats().length;
		int[] seats = flight.getSeats();
		while(i<length) {
			if(seats[i]==0) {
				seatNo = ""+classChosen+(i+1);
				this.seatNoInt = i+1;
				seats[i]=1;
				break;
			}
			i++;
		}
		
	}
	public Ticket(Passenger passenger, Flight flight) {
		super();
		this.passenger = passenger;
		this.flight = flight;
		this.setSeatNo(flight,flight.getClassChosen());
		this.setTicketID(passenger.getEmail().substring(0,4)+flight.getFlightNo().substring(0,3)+getSeatNo());
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
	public int getSeatNoInt() {
		return seatNoInt;
	}
	
}
