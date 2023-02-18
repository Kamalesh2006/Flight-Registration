package com.bookmyflight.admin;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AdminContollerCallBack {

	void decideOption(int option);
	void addFlight(String flightNo, String origin, String destination,LocalTime departureTime,LocalTime arrivalTime,
			String duration, int price, LocalDate date, int seatCapacity);
	void decideToContinue(char yn);
	void deleteFlight(String flightNo);

}
