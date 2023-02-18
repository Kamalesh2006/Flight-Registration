package com.bookmyflight.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private String flightNo;
	private String origin;
	private String destination;
	private LocalTime departureTime;
	private LocalTime ArrivalTime;
	private String duration;
	private int price;
	private LocalDate date;
	private int[] seatsArr;
	private char classChosen;
	private int seatCapacity;
	private int economySeatCount;
	private int businessSeatCount;
	private int tatkalSeatCount;
	
	
	public Flight(String flightNo, String origin, String destination,LocalTime departureTime,LocalTime arrivalTime,
			String duration, int price, LocalDate date, int seatCapacity) {
		super();
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		ArrivalTime = arrivalTime;
		this.duration = duration;
		this.price = price;
		this.date = date;
		this.seatCapacity = seatCapacity;
		setSeats(new int[seatCapacity]);
		this.tatkalSeatCount = (int)(seatCapacity*0.15);
		this.businessSeatCount = (seatCapacity/3)-tatkalSeatCount;
		economySeatCount = (seatCapacity-businessSeatCount);
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public int[] getSeats() {
		return seatsArr;
	}

	public void setSeats(int[] seatsArr) {
		this.seatsArr = seatsArr;
	}
	public int getEconomySeatCount() {
		return economySeatCount;
	}

	public void setEconomySeatCount(int economySeatCount) {
		this.economySeatCount = economySeatCount;
	}
	public int getBusinessSeatCount() {
		return businessSeatCount;
	}

	public void setBusinessSeatCount(int businessSeatCount) {
		this.businessSeatCount = businessSeatCount;
	}

	public char getClassChosen() {
		return classChosen;
	}

	public void setClassChosen(char classChosen) {
		this.classChosen = classChosen;
	}
	public int getTatkalSeatCount() {
		return tatkalSeatCount;
	}

	public void setTatkalSeatCount(int tatkalSeatCount) {
		this.tatkalSeatCount = tatkalSeatCount;
	}

	
}
