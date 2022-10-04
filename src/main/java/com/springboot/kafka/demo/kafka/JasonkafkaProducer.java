package com.springboot.kafka.demo.kafka;


import com.springboot.kafka.demo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JasonkafkaProducer {


    private static final Logger LOGGER = LoggerFactory.getLogger(JasonkafkaProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public JasonkafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data)
    {
        Message<User> userMessage = MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,"Jason-topic")
                                .build();
        LOGGER.info(String.format("Message sent %s " , data.toString()));
        kafkaTemplate.send(userMessage);
    }
}
