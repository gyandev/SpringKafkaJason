package com.springboot.kafka.demo.kafka;

import com.springboot.kafka.demo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JasonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JasonkafkaProducer.class);

    @KafkaListener(topics = "Jason-topic" ,groupId = "myGroup")
    public void consume(User message)
    {
        LOGGER.info(String.format("Jason Message is received --> %s" , message.toString()));
    }
}
