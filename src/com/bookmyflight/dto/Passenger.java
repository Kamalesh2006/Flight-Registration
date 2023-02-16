package com.bookmyflight.dto;

public class Passenger {
	String name;
	int age;
	char gender;
	String email;
	long phoneNo;
	Passenger(String name, int age, char gender,String email,long phoneNo){
		this.name  = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phoneNo= phoneNo;
	}
}
