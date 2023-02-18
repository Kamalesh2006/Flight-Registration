package com.bookmyflight.admin;

import com.bookmyflight.dto.Flight;

public interface AdminViewCallBack {

	void addFlights();

	void deleteFlights();

	void flightAlreadyExist(String flightNo);

	void goBackToLogin();

	void flightDoesNotExist(String flightNo);

	void flightRemovedSuccessfully(Flight f);

	void flightAddedSuccessfully(Flight flight);

}
