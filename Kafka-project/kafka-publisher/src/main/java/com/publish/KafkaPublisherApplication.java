package com.publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.publish.entity.User;

@RestController
@SpringBootApplication
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "spring-kafka1";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template.send(topic, "Hi " + name + " this is to inform that this message is coming frm your kafka publisher!");
		return "Data has been published";
	}
	
	@GetMapping("/publishjson")
	public String publishMessage() {
		User user = new User(101, "Nishant Gupta", new String[] {"Bangalore", "White field", "Prestige tech park"});
		template.send(topic, user);
		return "JSon data has been published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
