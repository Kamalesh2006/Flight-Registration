package com.bookmyflight.managetickets;

import java.util.Scanner;

import com.bookmyflight.availableflights.AvailableFlightsView;
import com.bookmyflight.booktickets.BookTicketsView;
import com.bookmyflight.cancelTickets.CancelTicketView;

public class ManageTicketView implements ManageTicketViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private ManageTicketControllerCallBack manageTicketController;
	private BookTicketsView bookTicketsView;
	private CancelTicketView cancelTicketView;
	private AvailableFlightsView availableFlightsView;
	public ManageTicketView(){
		manageTicketController = new ManageTicketController(this);
	}
	public void bookTickets() {
		System.out.println("Enter 1 to book ticket");
		System.out.println("Enter 2 to cancel booked tickets");
		System.out.println("Enter 3 to display all available flights");
		System.out.println("Enter 4 to exit application");
		int optionChosen = scanner.nextInt();
		manageTicketController.decideOptions(optionChosen);
	}
	@Override
	public void cancelTickets() {
		System.out.println("Cancel Booked Tickets");
		//calling cancel ticket module
		cancelTicketView = new CancelTicketView();
		cancelTicketView.showTicketsToCancel(this);
		
	}
	@Override
	public void chosenFailed() {
		System.out.println("Failed to book ticket");		
	}
	@Override
	public void showAvailableFlights() {
		//calling available flights module
		System.out.println("Showing Available flights");
		this.availableFlightsView= new  AvailableFlightsView();
		availableFlightsView.showAvailableFlights(this);
	}
	@Override
	public void callBackToBookTicket() {
		this.bookTicketsView=new BookTicketsView();
		bookTicketsView.selectFlightToBook(this);
	}
}
