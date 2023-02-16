package com.bookmyflight.booktickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookmyflight.availableflights.AvailableFlightsView;
import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public class BookTicketsView implements BookTicketsViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private BookTicketsControllerCallBack bookTicketsController;
	public BookTicketsView() {
		bookTicketsController = new BookTicketsController(this);
	}

	public void selectFlightToBook() {
		System.out.println("Enter your journey date:");
		String date = scanner.next();
		System.out.println("Enter your departure city");
		String departureCity = scanner.next();
		System.out.println("Enter your destination city");
		String destinationCity = scanner.next();
		bookTicketsController.showAvailableFlights(departureCity, destinationCity, date);
	}

	@Override
	public void printFlights(List<Flight> flights) {
		int sno = 1;
		for (Flight f : flights) {
			System.out.println(sno + " " + f.getFlightNo() + " " + f.getDate() + " " + f.getOrigin() + " "
					+ f.getDestination() + " " + f.getSeatCapacity());
			sno++;
		}
		System.out.println("Press " + (flights.size() + 1) + " to go back");
		System.out.println("Press corresponding number to book ticket");
		int option = scanner.nextInt();
		bookTicketsController.selectedFlight(option, flights);
	}

	@Override
	public void bookFlight(Flight flight) {
		List<Passenger> passengerList = new ArrayList<>();
		System.out.println("Enter no of passengers you want to add:");
		int size = scanner.nextInt();
		System.out.println("You have chosen " + flight.getFlightNo() + " available seats" + flight.getSeatCapacity());
		while (size>0) {
			System.out.println("Enter passenger name:");
			String name = scanner.next();
			System.out.println("Enter the age of the passenger:");
			int age = scanner.nextInt();
			System.out.println("Enter the Gender of the passenger (M/F)");
			char gender = scanner.next().charAt(0);
			System.out.println("Enter the email id of the passenger:");
			String email = scanner.next();
			System.out.println("Enter the phone number of the passenger:");
			long phoneNo = scanner.nextLong();
			passengerList.add(new Passenger(name, age, gender, email, phoneNo));
			size--;
		}
		bookTicketsController.addPassengersDetails(passengerList,flight);
	}

	@Override
	public void flightsEmpty(String error) {
		System.out.println(error);
		selectFlightToBook();
	}

	@Override
	public void ticketBookedSuccessfully(List<Ticket> ticketList) {
		System.out.println("Booked Tickets are ");
		for(Ticket ticket: ticketList) {
			System.out.println(ticket.getTicketID()+" Ticket ID booked for "+ticket.getPassenger().getEmail()+" in flight "+ticket.getFlight().getFlightNo()+" and your boarding date is "+ticket.getFlight().getDate());
		}
		selectFlightToBook();
	}
}
