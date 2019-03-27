package com.miss.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/26
 */
@RestController
@RequestMapping("ka")
public class KafkaTestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("publish")
    public String pub(@RequestParam("value") String value) {
        kafkaTemplate.send("myTopic",value);
        return value;
    }

}
