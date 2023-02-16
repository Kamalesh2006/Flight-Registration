package com.bookmyflight.booktickets;

import com.bookmyflight.repository.PassengerDB;

public class BookTicketsModel implements BookTicketsModelCallBack{
	private BookTicketsModelControllerCallBack bookTicketsModelControllerCallBack;
	private PassengerDB passengerDB = PassengerDB.getInstance();
	public BookTicketsModel(BookTicketsController bookTicketsController) {
		this.bookTicketsModelControllerCallBack = bookTicketsController;
	}
	@Override
	public void addPassengersToDB(String name, int age, char gender,String email,long phoneNo){
		passengerDB.addPassenger(name, age, gender, phoneNo, email);
		
	}

}
