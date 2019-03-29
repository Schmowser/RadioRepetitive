package de.schmowser.radio.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaController {

    @KafkaListener(topics = "test", groupId = "exampleGroup")
    public void listen(String msg) {
        System.out.println("Received Message in group exampleGroup: " + msg);
    }

}
