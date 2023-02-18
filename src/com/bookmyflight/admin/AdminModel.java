package com.bookmyflight.admin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.repository.FlightDB;

public class AdminModel implements AdminModelCallBack {
	private FlightDB flightInstance = FlightDB.getInstance();
	private AdminModelControllerCallBack adminController;
	public AdminModel(AdminController adminController) {
		this.adminController = adminController;
	}
	@Override
	public void addFlightToDBaddFlight(String flightNo, String origin, String destination, LocalTime departureTime,
			LocalTime arrivalTime, String duration, int price, LocalDate date, int seatCapacity) {
		Flight flight= new Flight(flightNo, origin, destination, departureTime, arrivalTime, duration, price, date, seatCapacity);
		flightInstance.addFlight(flight);
		adminController.flightAddedSuccess(flight);
		
	}
	@Override
	public boolean isFlightNoUnique(String flightNo) {
		List<Flight> flightTable = flightInstance.getFlightsInDB();
		for(Flight f: flightTable) {
			if(f.getFlightNo().equals(flightNo)) {
				return false;
			}
		}
		return true;
	}
	@Override
	public void deleteFlightInDB(String flightNo) {
		List<Flight> flightTable = flightInstance.getFlightsInDB();
		for(Flight f: flightTable) {
			if(f.getFlightNo().equals(flightNo)) {
				flightInstance.removeFlight(f);
				adminController.flightRemovedSuccessfully(f);
			}
		}
	}

}
