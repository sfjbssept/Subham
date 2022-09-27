package com.flight.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer flightnumber;
	private String airline;
	private String fromPlace;
	private String toPlace;
	private Integer startDateTime;
	private String endDateTime;
	private String scheduleddays;
	private String instrumentUsed;
	private String totalNumberofBusinessClassSeats;
	private String totalNumberofNonBusinessClassSeats;
	private Integer ticketCost;
	private Integer numberofRows;
	private String meal;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(Integer flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public Integer getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Integer startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getScheduleddays() {
		return scheduleddays;
	}
	public void setScheduleddays(String scheduleddays) {
		this.scheduleddays = scheduleddays;
	}
	public String getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public String getTotalNumberofBusinessClassSeats() {
		return totalNumberofBusinessClassSeats;
	}
	public void setTotalNumberofBusinessClassSeats(String totalNumberofBusinessClassSeats) {
		this.totalNumberofBusinessClassSeats = totalNumberofBusinessClassSeats;
	}
	public String getTotalNumberofNonBusinessClassSeats() {
		return totalNumberofNonBusinessClassSeats;
	}
	public void setTotalNumberofNonBusinessClassSeats(String totalNumberofNonBusinessClassSeats) {
		this.totalNumberofNonBusinessClassSeats = totalNumberofNonBusinessClassSeats;
	}
	public Integer getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Integer getNumberofRows() {
		return numberofRows;
	}
	public void setNumberofRows(Integer numberofRows) {
		this.numberofRows = numberofRows;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
	
	public Flight(Integer id, Integer flightnumber, String airline, String fromPlace, String toPlace,
			Integer startDateTime, String endDateTime, String scheduleddays, String instrumentUsed,
			String totalNumberofBusinessClassSeats, String totalNumberofNonBusinessClassSeats, Integer ticketCost,
			Integer numberofRows, String meal) {
		super();
		this.id = id;
		this.flightnumber = flightnumber;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduleddays = scheduleddays;
		this.instrumentUsed = instrumentUsed;
		this.totalNumberofBusinessClassSeats = totalNumberofBusinessClassSeats;
		this.totalNumberofNonBusinessClassSeats = totalNumberofNonBusinessClassSeats;
		this.ticketCost = ticketCost;
		this.numberofRows = numberofRows;
		this.meal = meal;
	}
	
	
	
}
