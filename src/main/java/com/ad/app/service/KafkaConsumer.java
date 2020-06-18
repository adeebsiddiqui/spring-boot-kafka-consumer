package com.ad.app.service;

import com.ad.app.model.Laptop;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "simple-topic", groupId = "simple-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "json-topic", groupId = "json-group", containerFactory = "laptopKafkaListenerFactory")
    public void consume(Laptop laptop) {
        System.out.println("Consumed message: " + laptop);
    }
}
