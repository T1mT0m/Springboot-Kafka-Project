package com.github.bwar.sb.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.bwar.sb.kafka.model.User;
import com.github.bwar.sb.kafka.producer.JsonKafkaProducer;
import com.github.bwar.sb.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")

public class MessageController {
	
	private KafkaProducer kafkaProducer;
	private JsonKafkaProducer jsonKafkaProducer;
	
	public MessageController(KafkaProducer kafkaProducer,
			JsonKafkaProducer jsonKafkaProducer) {
		this.kafkaProducer = kafkaProducer;
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	//http://localhost:8080/api/kafka/publish?message='Hello World to Springboot kafka'
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to Topic");
	}
	

	@GetMapping("/json")
	public ResponseEntity<String> publishJson(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message sent to Topic");
	}

	

}
