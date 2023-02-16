package com.bookmyflight.availableflights;

import java.util.List;
import java.util.Set;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.repository.FlightDB;

public class AvailableFlightsModel implements AvailableFlightsModelCallBack{
	private AvailableFlightsModelControllerCallBack availableFlightsModelController;
	private FlightDB flightInstance = FlightDB.getInstance();
	private List<Flight> allFlights;
	public AvailableFlightsModel(AvailableFlightsController availableFlightsController) {
		this.availableFlightsModelController = availableFlightsController;
	}
	@Override
	public void availableFlightsInDB() {
		allFlights = flightInstance.getFlightsInDB();
		availableFlightsModelController.retrievedFlightsData(allFlights);
	}
	@Override
	public void availableFlightsDestination() {
		Set<String> destinationCollections = flightInstance.getDestinationInDB();
		availableFlightsModelController.availableDestination(destinationCollections);
	}
	
}
