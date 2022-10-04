package com.springboot.kafka.demo.controller;

import com.springboot.kafka.demo.kafka.JasonkafkaProducer;
import com.springboot.kafka.demo.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private JasonkafkaProducer kafkaProducer;


    @Autowired
    public KafkaController(JasonkafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8086/api/v1/kafka/publish

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User data)
    {
        kafkaProducer.sendMessage(data);
        return ResponseEntity.ok("JasonMessage sent to the topic");

    }



}
