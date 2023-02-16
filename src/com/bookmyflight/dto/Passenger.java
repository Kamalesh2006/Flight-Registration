package com.bookmyflight.dto;

public class Passenger {
	private String name;
	private int age;
	private char gender;
	private final String email;
	private long phoneNo;
	public Passenger(String name, int age, char gender,String email, long phoneNo){
		this.name  = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phoneNo= phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}
