package com.cg.rabbitmqdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rabbitmqdemo.producer.RabbitMQProducer;

@RestController
@RequestMapping("api/v1")
public class MessageController {
	
	private RabbitMQProducer producer;

	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessgae(message);
		return new ResponseEntity<String>("Message sent to RabbitMQ...", HttpStatus.OK);
	}
	

}
