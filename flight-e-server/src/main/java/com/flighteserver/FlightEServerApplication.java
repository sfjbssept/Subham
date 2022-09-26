package com.flighteserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightEServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightEServerApplication.class, args);
	}

}
