package com.kube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootK8DemoApplication {
	
	@GetMapping("/hello")
	public String DisplayMessage() {
		return "You app has been deployed on a container using k8";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootK8DemoApplication.class, args);
	}

}
