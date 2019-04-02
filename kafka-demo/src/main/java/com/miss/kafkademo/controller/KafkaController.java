package com.miss.kafkademo.controller;

import com.miss.kafkademo.Service.KafkaProducer;
import com.miss.kafkademo.config.KafkaListenerConfig;
import com.miss.kafkademo.entity.Address;
import com.miss.kafkademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */

@RestController
@RequestMapping("/kafka/publish")
public class KafkaController {


    private final KafkaProducer kafkaProducer;



    @Autowired
    KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;

    }

    @PostMapping(value = "/user")
    public void sendUserMessageToKafkaTopic(@RequestBody User user,
                                        @RequestParam("times") int times) {
        for(int i = 0; i < times; i++) {
            user.setAge(i);
            this.kafkaProducer.sendUserMessage(user);
        }

    }

    @PostMapping(value = "address")
    public void sendAddMessageToKafkaTopic(@RequestBody Address address,
                                           @RequestParam("times") int times) {
        for (int i = 0; i < times; i++) {
            address.setStreet("第"+i+"大道");
            this.kafkaProducer.sendAddressMessage(address);
        }
    }
}