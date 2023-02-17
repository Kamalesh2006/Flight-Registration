package com.bookmyflight.booktickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookmyflight.availableflights.AvailableFlightsView;
import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;
import com.bookmyflight.managetickets.ManageTicketView;

public class BookTicketsView implements BookTicketsViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private BookTicketsControllerCallBack bookTicketsController;
	private ManageTicketView manageTicketView;
	public BookTicketsView() {
		bookTicketsController = new BookTicketsController(this);
	}

	public void selectFlightToBook(ManageTicketView manageTicketView) {
		this.manageTicketView=manageTicketView;
		System.out.println("Enter your Journey date:");
		String date = scanner.next();
		String result = bookTicketsController.getFlightDestinationOnDate(date);
		System.out.println(result);
		System.out.println("Enter your Departure city");
		String departureCity = scanner.next().toLowerCase();
		System.out.println("Enter your Destination city");
		String destinationCity = scanner.next().toLowerCase();
		bookTicketsController.showAvailableFlights(departureCity, destinationCity, date);
	}

	@Override
	public void printFlights(List<Flight> flights) {
		int sno = 1;
		for (Flight f : flights) {
			System.out.println("-----------------------------------");
			System.out.println("Press "+sno + " to book ");
			System.out.println("Flight: "+f.getFlightNo() + "\t\tDate: " + f.getDate());
			System.out.println("Origin City: " + f.getOrigin().toUpperCase() + "\t\tDestination: "+ f.getDestination().toUpperCase());
			System.out.println("Available Economic seats "+f.getEconomySeatCount()+"\tBusiness Seats:"+f.getBusinessSeatCount());
			sno++;
		}
		System.out.println("Press " + ((flights.size() + 1) + " to go back"));
		System.out.println("Press corresponding number to book ticket");
		int option = scanner.nextInt();
		bookTicketsController.selectedFlight(option, flights);
	}

	@Override
	public void bookFlight(Flight flight) {
		System.out.println("You have chosen " + flight.getFlightNo() + " available seats" + flight.getSeatCapacity()+" business class "+flight.getBusinessSeatCount()+" economy class seats "+flight.getEconomySeatCount());
		List<Passenger> passengerList = new ArrayList<>();
		System.out.println("Enter which class you want to book (B/E)");
		char classChosen = scanner.next().charAt(0);
		System.out.println("Available seats for class is "+bookTicketsController.getSeatforChosenFlight(classChosen,flight)+" and price is "+bookTicketsController.getPriceforChosenFlight(classChosen,flight));
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
		bookTicketsController.addPassengersDetails(passengerList,flight,classChosen);
	}

	@Override
	public void flightsEmpty(String error) {
		System.out.println(error);
		selectFlightToBook(manageTicketView);
	}

	@Override
	public void ticketBookedSuccessfully(List<Ticket> ticketList) {
		System.out.println("Booked Tickets are ");
		for(Ticket ticket: ticketList) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Ticket ID "+ticket.getTicketID()+"\tFlight:"+ticket.getFlight().getFlightNo()+"\tSeatNo:"+ticket.getSeatNo());
			System.out.println("Passenger Name: "+ticket.getPassenger().getName()+"\t\tPassenger Age: "+ticket.getPassenger().getAge());
			System.out.println("Boarding date is " + ticket.getFlight().getDate()+"\t\tJourney duration "+ticket.getFlight().getDuration()+"hrs");
			System.out.println("-----------------------------------------------------------------");
		}
		callBackToManageTicket();
	}

	@Override
	public void callBackToManageTicket() {
		manageTicketView.bookTickets();
	}
}
