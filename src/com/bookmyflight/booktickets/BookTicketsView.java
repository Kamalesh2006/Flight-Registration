package com.bookmyflight.booktickets;

import java.util.Scanner;

public class BookTicketsView implements BookTicketsViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private BookTicketsControllerCallBack bookTicketsController;
	public BookTicketsView() {
		bookTicketsController = new BookTicketsController(this);
	}
	public void bookTickets() {
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
