package com.cg.rabbitmqdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rabbitmqdemo.dto.User;
import com.cg.rabbitmqdemo.producer.RabbitMQJsonProducer;

@RestController
@RequestMapping("api/v1")
public class MessageJsonController {

	private RabbitMQJsonProducer jsonProducer;

	public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		jsonProducer.sendJsonMessage(user);
		return new ResponseEntity<String>("Json message sent to RabbitMQ...", HttpStatus.OK);
	}
}
