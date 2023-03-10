package com.bookmyflight.availableflights;

import java.util.List;
import java.util.Set;

import com.bookmyflight.dto.Flight;

public class AvailableFlightsController implements AvailableFlightsControllerCallBack,AvailableFlightsModelControllerCallBack {
	private AvailableFlightsViewCallBack availableFlightsView;
	private AvailableFlightsModelCallBack availableFlightsModel;
	public AvailableFlightsController(AvailableFlightsView availableFlightsView) {
		this.availableFlightsView = availableFlightsView;
		availableFlightsModel= new AvailableFlightsModel(this);
	}
	@Override
	public void showFlights(int option) {
		switch(option) {
		case 1:
			availableFlightsModel.availableFlightsInDB();
			break;
		case 2:
			availableFlightsModel.availableFlightsDestination();
			break;
		case 3:
			availableFlightsView.callBackToManageTicket();
		}
	}
	@Override
	public void retrievedFlightsData(List<Flight> allFlights) {
		String result ="-----------------------------------------------------";
		for(Flight f:allFlights) {
			result = result + "\nDate: "+ f.getDate()+" \t\tFlight ID:"+f.getFlightNo()+"\nBoarding city:"+f.getOrigin()+" \t\tDestination city "+f.getDestination()+"\nDtime "+f.getDepartureTime()+"\t\t\tAtime "+f.getArrivalTime()+"\nJourney Duration:"+f.getDuration()+"\t\tAvailable Seats "+f.getSeatCapacity();	
			result = result + "\n-----------------------------------------------------";
		}
		availableFlightsView.retrievedFlightsDetails(result);
	}
	@Override
	public void showAvailableDestination() {
		availableFlightsModel.availableFlightsDestination();
		
	}
	@Override
	public void availableDestination(Set<String> destinationCollections) {
		availableFlightsView.showDestination(destinationCollections);
	}

}
