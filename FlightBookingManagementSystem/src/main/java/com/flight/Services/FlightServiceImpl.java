package com.flight.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.Entity.Flight;
import com.flight.exception.ResourceNotFoundExcep;
import com.flight.repo.IFlightRepository;
import com.flight.Services.IFlightService;

@Service
public class FlightServiceImpl implements IFlightService {


	@Autowired
	IFlightRepository flightRepository;
	
	@Override
	public Integer addFlight(Flight flight) {
		Flight addFlight = flightRepository.save(flight);
		return addFlight.getId();
	}

	@Override
	public List<Flight> getAllFlights() {
		
		return flightRepository.findAll();
	}

	@Override
	public Optional<Flight> getFlight(Integer Id) {
		
		return flightRepository.findById(Id);
	}
	
	@Override
	public Flight updateFlight(Flight flight, Integer Id) {
		Flight existingFlight =flightRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundExcep("Flight", "id", Id));
		
		existingFlight.setFlightnumber(flight.getFlightnumber());
		existingFlight.setAirline(flight.getAirline());
		existingFlight.setFromPlace(flight.getFromPlace());
		existingFlight.setToPlace(flight.getToPlace());
		existingFlight.setStartDateTime(flight.getStartDateTime());
		existingFlight.setEndDateTime(flight.getEndDateTime());
		existingFlight.setScheduleddays(flight.getScheduleddays());
		existingFlight.setToPlace(flight.getInstrumentUsed());
		existingFlight.setTotalNumberofBusinessClassSeats(flight.getTotalNumberofBusinessClassSeats());
		existingFlight.setTotalNumberofNonBusinessClassSeats(flight.getTotalNumberofNonBusinessClassSeats());
		existingFlight.setTicketCost(flight.getTicketCost());
		existingFlight.setNumberofRows(flight.getNumberofRows());
		existingFlight.setMeal(flight.getMeal());
		
		// we will update the values and then save the new updated data
		flightRepository.save(existingFlight);
		return existingFlight;
	}

	@Override
	public void deleteflight(Integer Id) {
		flightRepository.deleteById(Id);
		
	}

}
