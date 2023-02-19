package com.bookmyflight.repository;

import java.time.LocalDate;
import java.time.LocalTime;
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
		flightsTable.add(new Flight("Boeing-614", "chennai", "bengaluru", LocalTime.of(13, 0), LocalTime.of(14,00), "1:00", 8000,
				LocalDate.of(2023, 02, 20), 120));
		flightsTable.add(new Flight("AirAsia-001", "chennai", "newdelhi", LocalTime.of(15, 0), LocalTime.of(18, 30), "3:30", 21600,
				LocalDate.of(2023, 02, 21), 160));
		flightsTable.add(new Flight("IndiGo-6E-6012", "bengaluru", "chennai",LocalTime.of(6, 0), LocalTime.of(7, 0),"1:00", 7000,
				LocalDate.of(2023, 02, 20), 60));
		flightsTable.add(new Flight("Vistara-UK-866", "chennai", "dubai",LocalTime.of(17, 0), LocalTime.of(23, 0),"6:00", 33000,
				LocalDate.of(2023, 03, 01), 80));
		
		//default available user in database
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


	public User getUser(String userid) {
		for(User user: userTable) {
			if(user.getEmail().equals(userid))
				return user;
		}
		return null;
	}

	public void addFlight(Flight flight) {
		this.flightsTable.add(flight);
	}

	public void removeFlight(Flight f) {
		flightsTable.remove(f);
	}

}
