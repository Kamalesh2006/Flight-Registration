package com.bookmyflight.availableflights;


import java.util.Scanner;
import java.util.Set;

import com.bookmyflight.booktickets.BookTicketsView;


public class AvailableFlightsView implements AvailableFlightsViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private AvailableFlightsControllerCallBack availableFlightsController;
	
	public AvailableFlightsView() {
		this.availableFlightsController=new AvailableFlightsController(this);
	}
	public void showAvailableFlights() {
		System.out.println("Press 1 to see Full flight details");
		System.out.println("Press 2 to see Available destination");
		System.out.println("Press 3 to book flights");
		int option = scanner.nextInt();
		availableFlightsController.showFlights(option);
	}
	@Override
	public void retrievedFlightsDetails(String flightsData) {
		System.out.println("Available flights are listed below:");
		System.out.println(flightsData);
	}
	@Override
	public void showDestination(Set<String> destinationCollections) {
		for(String destination: destinationCollections) {
			System.out.println(destination);
		}
		showAvailableFlights();
	}
}
