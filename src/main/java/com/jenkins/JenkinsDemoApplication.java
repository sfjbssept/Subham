package com.jenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsDemoApplication implements CommandLineRunner{
	
	public static final Logger Logger = LoggerFactory.getLogger(JenkinsDemoApplication.class);

	public static void main(String[] args) {
		Logger.info("This is a CI Job");
		SpringApplication.run(JenkinsDemoApplication.class, args);
	}
			
	@Override		
	public void run(String... args) throws Exception {
		Logger.info("This is the second task of this buils");
	}

}
