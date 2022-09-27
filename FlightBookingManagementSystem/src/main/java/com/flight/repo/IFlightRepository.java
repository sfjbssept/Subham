package com.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.Entity.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Integer>{

}
