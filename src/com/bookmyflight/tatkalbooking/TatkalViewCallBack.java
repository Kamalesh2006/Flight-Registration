package com.bookmyflight.tatkalbooking;

import java.time.LocalDate;
import java.util.List;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;

public interface TatkalViewCallBack {

	void nextDayFlight(List<Flight> nextDayFlight, LocalDate date);

	void insufficientTatkalSeat(Flight flight, List<Passenger> passengerList);

	void tatkalBookedSuccessfully(Flight flight, List<Passenger> passengerList, List<Ticket> ticketsBooked);

	void bookTatkalFlight(Flight flight);

}
