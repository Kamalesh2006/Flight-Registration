package com.bookmyflight.dto;

public class Flight {
	private String flightNo;
	private String origin;
	private String destination;
	private String departureTime;
	private String ArrivalTime;
	private String duration;
	private int price;
	private String date;
	private int[] seatsArr;
	private char classChosen;
	private int seatCapacity;
	private int economySeatCount;
	private int businessSeatCount;
	
	public Flight(String flightNo, String origin, String destination, String departureTime, String arrivalTime,
			String duration, int price, String date, int seatCapacity) {
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
		this.businessSeatCount = seatCapacity/3;
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	
}
