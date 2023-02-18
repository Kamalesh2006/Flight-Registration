package com.bookmyflight.admin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.login.LoginView;

public class AdminView implements AdminViewCallBack {
	private AdminContollerCallBack adminController;
	private LoginView loginView;
	private Scanner scanner = new Scanner(System.in);
	public AdminView() {
		this.adminController = new AdminController(this);
	}
	public void adminAccess(LoginView loginView) {
		this.loginView = loginView;
		System.out.println("Welcome Admin");
		System.out.println("Press 1 to Add Flights to the database");
		System.out.println("Press 2 to Delete Flights from the database");
		System.out.println("Press 3 to go back to login view");
		int option = scanner.nextInt();
		adminController.decideOption(option);
	}
	@Override
	public void addFlights() {
		
		System.out.println("Enter Flight No:");
		String flightNo = scanner.next();
		System.out.println("Enter FROM destination of the flight:");
		String origin = scanner.next().toLowerCase();
		System.out.println("Enter the REACH destination");
		String destination = scanner.next().toLowerCase();
		System.out.println("Enter the Departure time:(hh:mm)");
		String departTime = scanner.next();
		LocalTime departureTime = LocalTime.parse(departTime);
		System.out.println("Enter the Arrival time (hh/mm):");
		String arrTime = scanner.next();
		LocalTime arrivalTime = LocalTime.parse(arrTime);
		System.out.println("Enter the duration of the journey");
		String duration = scanner.next();
		System.out.println("Enter the date of the flight departure (dd-mm-yyyy):");
		String dt = scanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate date = LocalDate.parse(dt, formatter);
		System.out.println("Enter the seat capacity:");
		int seatCapacity = scanner.nextInt();
		adminController.addFlight(flightNo, origin, destination, departureTime, departureTime, duration, seatCapacity, date, seatCapacity);
		
	}
	@Override
	public void deleteFlights() {
		System.out.println("Enter the flightNo to delete");
		String flightNo = scanner.next();
		adminController.deleteFlight(flightNo);
	}
	@Override
	public void flightAlreadyExist(String flightNo) {
		System.out.println("Flight already exist "+flightNo);
		System.out.println("Do you want to continue:(Y/N)");
		char yn = scanner.next().charAt(0);
		adminController.decideToContinue(yn);
		
	}
	@Override
	public void goBackToLogin() {
		this.loginView.userInput();
	}
	@Override
	public void flightDoesNotExist(String flightNo) {
		System.out.println("Flight Doesnot exist in the database");
		deleteFlights();
	}
	@Override
	public void flightRemovedSuccessfully(Flight f) {
		System.out.println("FlightNo"+f.getFlightNo()+" from "+f.getOrigin()+" to "+f.getDestination()+" is successfully deleted");
		adminAccess(loginView);
	}
	@Override
	public void flightAddedSuccessfully(Flight f) {
		System.out.println("FlightNo"+f.getFlightNo()+" from "+f.getOrigin()+" to "+f.getDestination()+" is successfully Added to the database");
		adminAccess(loginView);
	}
}
