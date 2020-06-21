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

    //'groupId' for Consumers is mandatory. It can be defined either as a property in annotation like above or in the ConsumerFactory configuration like below

    @KafkaListener(topics = "json-topic", containerFactory = "laptopKafkaListenerFactory") //if ContainerFactory used, its id is mandatory here
    public void consume(Laptop laptop) {
        System.out.println("Consumed message: " + laptop);
    }
}
