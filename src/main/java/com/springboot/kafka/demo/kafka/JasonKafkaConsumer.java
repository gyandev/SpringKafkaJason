package com.springboot.kafka.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JasonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JasonkafkaProducer.class);

    @KafkaListener(topics = "JasonGyan-topic" ,groupId = "myGroup")
    public void consume(String message)
    {
        LOGGER.info(String.format("Message is received --> %s" , message));
    }
}
