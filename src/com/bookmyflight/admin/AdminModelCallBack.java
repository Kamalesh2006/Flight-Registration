package com.bookmyflight.admin;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AdminModelCallBack {
	void addFlightToDBaddFlight(String flightNo, String origin, String destination, LocalTime departureTime,
			LocalTime arrivalTime, String duration, int price, LocalDate date, int seatCapacity);

	boolean isFlightNoUnique(String flightNo);

	void deleteFlightInDB(String flightNo);
}
