package com.bookmyflight.booktickets;

import java.util.List;

import com.bookmyflight.dto.Flight;

public interface BookTicketsModelControllerCallBack {

	void flightsOnDate(List<Flight> result);

}
