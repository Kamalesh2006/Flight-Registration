package com.bookmyflight.availableflights;

import java.util.List;
import java.util.Set;

import com.bookmyflight.dto.Flight;

public interface AvailableFlightsModelControllerCallBack {

	void retrievedFlightsData(List<Flight> allFlights);

	void availableDestination(Set<String> destinationCollections);
	
}
