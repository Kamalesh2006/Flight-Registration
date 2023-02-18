package com.bookmyflight.admin;

import java.time.LocalDate;
import java.time.LocalTime;

import com.bookmyflight.dto.Flight;

public class AdminController implements AdminContollerCallBack, AdminModelControllerCallBack {
	private AdminModelCallBack adminModel;
	private AdminViewCallBack adminView;
	public AdminController(AdminView adminView) {
		this.adminView = adminView;
		this.adminModel = new AdminModel(this);
	}
	@Override
	public void decideOption(int option) {
		switch(option) {
		case 1:
			adminView.addFlights();
			break;
		case 2:
			adminView.deleteFlights();
			break;
		case 3:
			adminView.goBackToLogin();
			break;
		}
	}
	@Override
	public void addFlight(String flightNo, String origin, String destination, LocalTime departureTime,
			LocalTime arrivalTime, String duration, int price, LocalDate date, int seatCapacity) {
		if(adminModel.isFlightNoUnique(flightNo)) {
			adminModel.addFlightToDBaddFlight(flightNo, origin, destination, departureTime, arrivalTime, duration, price, date, seatCapacity);
		}
		else {
			adminView.flightAlreadyExist(flightNo);
		}
		
	}
	@Override
	public void flightAddedSuccess(Flight flight) {
		adminView.flightAddedSuccessfully(flight);
	}
	@Override
	public void decideToContinue(char yn) {
		switch(yn) {
		case 'Y':
			adminView.addFlights();
			break;
		case 'N':
			adminView.goBackToLogin();
			break;
		}
	}
	@Override
	public void deleteFlight(String flightNo) {
		if(!adminModel.isFlightNoUnique(flightNo))
			adminModel.deleteFlightInDB(flightNo);
		else
			adminView.flightDoesNotExist(flightNo);
	}
	@Override
	public void flightRemovedSuccessfully(Flight f) {
		adminView.flightRemovedSuccessfully(f);
	}

}
