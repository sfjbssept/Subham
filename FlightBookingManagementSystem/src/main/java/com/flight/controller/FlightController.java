package com.flight.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.Entity.Flight;
import com.flight.Services.IFlightService;



@RestController
public class FlightController {
	
	@Autowired
	IFlightService flightService;
	
	@PostMapping("/addflight")
	Integer addflight(@RequestBody Flight flight) {
		Integer id = flightService.addFlight(flight);
		System.out.println(id);
		return id;
	}
	@GetMapping("/allflights")
	public List<Flight> getAllFlights(){
		return flightService.getAllFlights();
	}
	
	@GetMapping("/flight/{id}")
	Optional<Flight> getFlight(@PathVariable Integer id){
		Optional<Flight> flight =flightService.getFlight(id);
		return flight;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable("id") Integer Id,@RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightService.updateFlight(flight, Id), HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{Id}")
	public ResponseEntity<Flight> deleteflight(@PathVariable Integer Id){
		System.out.println(Id);
		ResponseEntity<Flight> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			flightService.deleteflight(Id);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			// TODO: handle exception
		}
		return responseEntity;
	}



}
