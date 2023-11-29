package com.cg.rabbitmqdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.cg.rabbitmqdemo.dto.User;

@Service
public class RabbitMQJsonConsumer {

	private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.json.queue.name}"} )
	public void consumeJsonMessage(User user) {
		LOGGER.info(String.format("Received Json meassage -> %s", user.toString()));
	}
}
