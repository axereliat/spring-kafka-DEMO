package com.kafka1.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public HomeController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/")
    public @ResponseBody String home() {
        kafkaTemplate.send("greeting", "Hi!");

        return "Message sent!";
    }
}
