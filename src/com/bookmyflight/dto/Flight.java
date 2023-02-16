package com.bookmyflight.dto;

public class Flight {
	int flightNo;
	String origin;
	String destination;
	String departureTime;
	String ArrivalTime;
	String duration;
	int price;
	char Class;
	String date;
	int seatCapacity;
	public Flight(int flightNo, String origin, String destination, String departureTime, String arrivalTime,
			String duration, int price, char class1, String date,int seatCapacity) {
		super();
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		ArrivalTime = arrivalTime;
		this.duration = duration;
		this.price = price;
		Class = class1;
		this.date = date;
		this.seatCapacity = seatCapacity;
	}
}
