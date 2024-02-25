package com.cloud.delivery.controller;

import com.cloud.delivery.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> updateLocation(){
        kafkaService.updateLocation("("+Math.round(Math.random()*100)+","+Math.round(Math.random()*100)+")");
        return new ResponseEntity<>(Map.of("message", "Location Update"),HttpStatus.OK);
    }
}
