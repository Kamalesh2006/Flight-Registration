package com.bookmyflight.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bookmyflight.dto.Flight;
import com.bookmyflight.dto.Passenger;
import com.bookmyflight.dto.Ticket;
import com.bookmyflight.dto.User;

public class FlightDB {
	private static FlightDB flightInstance;
	private List<Flight> flightsTable = new ArrayList<>();
	private List<User> userTable = new ArrayList<>();
	private List<Passenger> passengerTable = new ArrayList<>();
	private List<Ticket> ticketTable = new ArrayList<>();
	
	private FlightDB() {
		// default available flights in database
		flightsTable.add(new Flight("Boeing-614", "chennai", "bengaluru", "01:00pm", "02:00pm", "1:00", 8000,
				"01/03/2023", 120));
		flightsTable.add(new Flight("AirAsia-001", "chennai", "newdelhi", "03:00pm", "06:30pm", "3:30", 21600,
				"01/03/2023", 160));
		flightsTable.add(new Flight("IndiGo-6E-6012", "bengaluru", "chennai", "06:00am", "7:00am", "1:00", 7000,
				"02/03/2023", 60));
		flightsTable.add(new Flight("Vistara-UK-866", "chennai", "dubai", "7:00pm", "01:00am", "6:00", 33000,
				"01/03/2023", 80));
		userTable.add(new User("Kamalesh","kamalesh@gmail.com","kamal"));
	}

	public static FlightDB getInstance() {
		if (flightInstance == null) {
			flightInstance = new FlightDB();
		}
		return flightInstance;
	}

	public List<Flight> getFlightsInDB() {
		return flightsTable;
	}

	public Set<String> getDestinationInDB() {
		Set<String> result = new HashSet<>();
		for (Flight f : flightsTable) {
			result.add(f.getDestination());
		}
		return result;
	}

	public List<Flight> getFlightsOnDate(String departureCity, String destinationCity, String date) {
		List<Flight> result = new ArrayList<>();
		for (Flight f : flightsTable) {
			if (f.getDate().equals(date) && f.getDestination().equals(destinationCity)
					&& f.getOrigin().equals(departureCity))
				result.add(f);
		}
		return result;
	}

	public void addUserToDB(String name, String email, String password) {
		User user = new User(name,email,password);
		userTable.add(user);
	}

	public boolean userIdExistInDB(String userID,String password) {
		for (int i = 0; i < userTable.size(); i++) {
			if (userTable.get(i).getEmail().equals(userID) && userTable.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public void addPassenger(String name, int age, char gender, long phoneNo, String email) {
		passengerTable.add(new Passenger(name, age, gender, email, phoneNo));
	}

	public void addTickets(List<Ticket> ticketList) {
		ticketTable.addAll(ticketList);
	}

	public List<Ticket> getTickets() {
		return ticketTable;
	}

	public void deleteTicket(Ticket ticket) {
		char classChosen = ticket.getFlight().getClassChosen();
		if(classChosen=='B') {
			ticket.getFlight().setBusinessSeatCount(ticket.getFlight().getBusinessSeatCount()+1);
		}
		else {
			ticket.getFlight().setEconomySeatCount(ticket.getFlight().getEconomySeatCount()+1);
		}
		int seatNo= ticket.getSeatNoInt();
		int[] seatArr = ticket.getFlight().getSeats();
		seatArr[seatNo-1]=0;
		ticket.getFlight().setSeats(seatArr);
		ticket.getFlight().setSeatCapacity(ticket.getFlight().getSeatCapacity()+1);
		ticketTable.remove(ticket);
	}

	public List<Flight> getFlightDatabyDate(String date) {
		List<Flight> result = new ArrayList<>();
		for(Flight f: flightsTable) {
			if(f.getDate().equals(date)) {
				result.add(f);
			}
		}
		return result;
	}

	public User getUser(String userid) {
		for(User user: userTable) {
			if(user.getEmail().equals(userid))
				return user;
		}
		return null;
	}

}
