package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;

public interface TatkalModelControllerCallBack {

	void obtainedFlightDetails(List<Flight> flightDetails, LocalDate date, String departureCity, String destinationCity);

}
