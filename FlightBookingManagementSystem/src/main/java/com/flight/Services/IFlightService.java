package com.flight.Services;

import java.util.List;
import java.util.Optional;

import com.flight.Entity.Flight;

public interface IFlightService {
	
	Integer addFlight(Flight flight);

	public List<Flight> getAllFlights();
	
	Optional<Flight> getFlight(Integer Id);
	
	Flight updateFlight(Flight flight, Integer Id);
	
	public void deleteflight(Integer Id);

}
