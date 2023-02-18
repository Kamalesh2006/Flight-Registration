package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookmyflight.booktickets.BookTicketsView;
import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public class TatkalView implements TatkalViewCallBack{
	private BookTicketsView bookTicketsView;
	private TatkalControllerCallBack tatkalController;
	private Scanner scanner = new Scanner(System.in);
	public TatkalView(){
		this.tatkalController = new TatkalController(this);
	}
	public void showTatkal(BookTicketsView bookTicketsView) {
		this.bookTicketsView = bookTicketsView;
		System.out.println("Enter the Boarding location:");
		String departureCity = scanner.next().toLowerCase();
		System.out.println("Enter the Destination location:");
		String destinationCity = scanner.next().toLowerCase();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		System.out.println("Date:"+date+"\t\tTime:"+time);
		System.out.println("Showing Available Flights for the next day\n");
		tatkalController.getFlightsOnDate(date,departureCity,destinationCity);
		
	}
	@Override
	public void nextDayFlight(List<Flight> nextDayFlight, LocalDate date) {
		int sno=1;
		System.out.println("Select number to book tatkal ticket");
		for(Flight f: nextDayFlight) {
			System.out.println(sno++ + ")----------------------------------------------------");
			System.out.println("Flight:"+f.getFlightNo()+"\tOrigin:"+f.getOrigin()+"\tDestination:"+f.getDestination());
			System.out.println("Price:"+f.getPrice()+"\tDeparture Time:"+f.getDepartureTime()+"\tReaching time:"+f.getArrivalTime());
			System.out.println("Available Seat:"+f.getSeatCapacity()+"("+f.getTatkalSeatCount()+" Tatkal Seats)"+"\t\t"+f.getDate()+"\n");
		}
		int option = scanner.nextInt();
		tatkalController.decideTatkalFlight(option, nextDayFlight);
	}
	@Override
	public void insufficientTatkalSeat(Flight flight,List<Passenger> passengerList) {
		System.out.println("For "+flight.getFlightNo()+" no seats available");
		showTatkal(bookTicketsView);
	}
	@Override
	public void tatkalBookedSuccessfully(Flight flight, List<Passenger> passengerList, List<Ticket> ticketsBooked) {
		bookTicketsView.ticketBookedSuccessfully(ticketsBooked);
	}
	@Override
	public void bookTatkalFlight(Flight flight) {
		List<Passenger> passengerList = new ArrayList<>();
		System.out.println("Flight:"+flight.getFlightNo()+"\tAvailable Seats:"+flight.getSeatCapacity());
		System.out.println("Enter no of passengers you want to add:");
		int size = scanner.nextInt();
		while (size-->0) {
			System.out.println("Enter passenger name:");
			String name = scanner.next();
			System.out.println("Enter the email id of the passenger:");
			String email = scanner.next();
			System.out.println("Enter the age of the passenger:");
			int age = scanner.nextInt();
			System.out.println("Enter the Gender of the passenger (M/F)");
			char gender = scanner.next().charAt(0);
			System.out.println("Enter the phone number of the passenger:");
			long phoneNo = scanner.nextLong();
			passengerList.add(new Passenger(name, age, gender, email, phoneNo));
		}
		tatkalController.bookTatkalTicket(flight,passengerList);
	}
}
