package com.bookmyflight.availableflights;

import java.util.List;

import com.bookmyflight.dto.Flight;

public class AvailableFlightsController implements AvailableFlightsControllerCallBack,AvailableFlightsModelControllerCallBack {
	private AvailableFlightsViewCallBack availableFlightsView;
	private AvailableFlightsModelCallBack availableFlightsModel;
	public AvailableFlightsController(AvailableFlightsView availableFlightsView) {
		this.availableFlightsView = availableFlightsView;
		availableFlightsModel= new AvailableFlightsModel(this);
	}
	@Override
	public void showFlights() {
		availableFlightsModel.availableFlightsInDB();
	}
	@Override
	public void retrievedFlightsData(List<Flight> allFlights) {
		String flightsData = "";
		for(Flight f: allFlights) {
			flightsData += f+"\n";
		}
		availableFlightsView.retrievedFlightsDetails(flightsData);
	}

}
