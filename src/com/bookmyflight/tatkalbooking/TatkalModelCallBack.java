package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;


public interface TatkalModelCallBack {

	void getFlightsOnNextDay(LocalDate date, String departureCity, String destinationCity);

}
