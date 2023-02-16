package com.bookmyflight.availableflights;

import java.util.List;
import java.util.Set;

public interface AvailableFlightsViewCallBack {

	void retrievedFlightsDetails(String flightsData);

	void showDestination(Set<String> destinationCollections);

}
