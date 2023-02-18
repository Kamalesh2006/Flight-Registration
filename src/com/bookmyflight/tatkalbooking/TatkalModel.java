package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.repository.FlightDB;

public class TatkalModel implements TatkalModelCallBack{
	private FlightDB flightInstance = FlightDB.getInstance();
	private TatkalModelControllerCallBack tatkalController;
	public TatkalModel(TatkalController tatkalController) {
		this.tatkalController = tatkalController;
	}
	@Override
	public void getFlightsOnNextDay(LocalDate date, String departureCity, String destinationCity) {
		List<Flight> flightDetails = flightInstance.getFlightsInDB();		
		tatkalController.obtainedFlightDetails(flightDetails,date,departureCity,destinationCity);
	}

}
