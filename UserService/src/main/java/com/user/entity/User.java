package com.user.entity;

public class User {
	
	private String name;
	private String gender;
	private String age;
	private String optForMeal;
	private String seatNumber;
	
	public User(String name,String gender,String age,String optForMeal,String seatNumber ) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.optForMeal = optForMeal;
		this.seatNumber = seatNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOptForMeal() {
		return optForMeal;
	}
	public void setOptForMeal(String optForMeal) {
		this.optForMeal = optForMeal;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
