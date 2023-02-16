package com.bookmyflight.booktickets;

import java.util.List;
import java.util.Scanner;

import com.bookmyflight.availableflights.AvailableFlightsView;
import com.bookmyflight.dto.Flight;

public class BookTicketsView implements BookTicketsViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private AvailableFlightsView availableFlights;
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
		bookTicketsController.showAvailableFlights(date,departureCity,destinationCity);
	}
	@Override
	public void printFlights(List<Flight> flights) {
		int sno=1;
		for(Flight f:flights) {
			System.out.println(sno+" "+f.getFlightNo()+" "+f.getDate()+" "+f.getOrigin()+" "+f.getDestination()+" "+f.getSeatCapacity());
			sno++;
		}
		System.out.println("Press corresponding number to book ticket");
		int option = scanner.nextInt();
		bookTicketsController.selectedFlight(option,flights);
	}
	@Override
	public void bookFlight(Flight flight) {
		System.out.println("You have chosen "+flight.getFlightNo());
		System.out.println("Enter passenger name:");
		String name = scanner.next();
		System.out.println("Enter the age of the passenger:");
		int age = scanner.nextInt();
		System.out.println("Enter the Gender of the passenger (M/F)");
		char gender = scanner.next().charAt(0);
		System.out.println("Enter the phone number of the passenger:");
		long phoneNo = scanner.nextLong();
		System.out.println("Enter the email id of the passenger:");
		String email = scanner.next();
		bookTicketsController.passengerDetails(name,age,gender,email,phoneNo);
	}
}
