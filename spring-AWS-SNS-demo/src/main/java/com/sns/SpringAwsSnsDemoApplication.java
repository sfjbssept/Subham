package com.sns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@RestController
public class SpringAwsSnsDemoApplication {

	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	String TOPIC_ARN = "arn:aws:sns:us-east-1:850763061324:Shubham-topic";
	
	@GetMapping("/subcription/{email}")
	public String addSubcription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN,"email", email);
		amazonSNSClient.subscribe(request);
		return "subcription request is pending, to confirm the subscription check your email :" +email;
	}
	
	@GetMapping("/sendnotification")
	public String publishMessageToTopic() {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Message from you springboot app");
		amazonSNSClient.publish(publishRequest);
		return "Notification sent successfully";
	}
	
	private String buildEmailBody() {
		return "Dear Customer, \n" +
				"\n" +
				"we are offering 50% off on all jeans and Tshirts "+"\n"+
				"Please visit our nearest store to avail this offer, minimum purchase value is 4000, " + "\n" +
				"Offers lasts till 9th December";
	 
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringAwsSnsDemoApplication.class, args);
	}

}
