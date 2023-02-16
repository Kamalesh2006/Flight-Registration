package com.bookmyflight.availableflights;

public class AvailableFlightsView implements AvailableFlightsViewCallBack {
	private AvailableFlightsControllerCallBack availableFlightsController;
	public AvailableFlightsView() {
		this.availableFlightsController=new AvailableFlightsController(this);
	}
	public void showAvailableFlights() {
		System.out.println("Available flights are listed below:");
		availableFlightsController.showFlights();
	}
	@Override
	public void retrievedFlightsDetails(String flightsData) {
		System.out.println(flightsData);
	}
}
