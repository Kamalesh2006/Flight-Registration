package com.bookmyflight.managetickets;

import java.util.Scanner;

public class ManageTicketView implements ManageTicketViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private ManageTicketControllerCallBack manageTicketController;
	public ManageTicketView(){
		manageTicketController = new ManageTicketController(this);
	}
	public void bookTickets() {
		System.out.println("Enter 1 to book ticket");
		System.out.println("Enter 2 to cancel ticket");
		int optionChosen = scanner.nextInt();
		manageTicketController.decideOptions(optionChosen);
	}
	@Override
	public void cancelTickets() {
		System.out.println("Showing Cancel Booked Tickets");
		//calling cancel ticket module
		
	}
	@Override
	public void chosenFailed() {
		System.out.println("Failed to book ticket");		
	}
	@Override
	public void showAvailableFlights() {
		System.out.println("Showing Available flights");
		//calling available flights module
	}
}
