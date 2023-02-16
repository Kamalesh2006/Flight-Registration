package com.bookmyflight.booktickets;

public interface BookTicketsModelCallBack {

	void addPassengersToDB(String name, int age, char gender,String email,long phoneNo);


	void showFlightsOnDate(String departureCity, String destinationCity, String date);

}
