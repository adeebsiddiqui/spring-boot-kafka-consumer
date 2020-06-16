package com.ad.app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "simple-topic", groupId = "simple-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
