package com.jenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsDemoApplicationTests {

	public static final Logger Logger = LoggerFactory.getLogger(JenkinsDemoApplication.class);

	@Test
	void contextLoads() {
		Logger.info("This is the test case running");
		assertEquals(true,true);
	}

}
