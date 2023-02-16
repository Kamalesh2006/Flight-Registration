package com.bookmyflight.availableflights;

import java.util.List;

import com.bookmyflight.dto.Flight;

public interface AvailableFlightsModelControllerCallBack {

	void retrievedFlightsData(List<Flight> allFlights);
	
}
