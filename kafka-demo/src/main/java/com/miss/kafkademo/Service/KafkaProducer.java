package com.miss.kafkademo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */
@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String USER_TOPIC = "users";
    private static final String ADD_TOPIC = "address";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUserMessage(Object user) {
        logger.info(user.toString());
        this.kafkaTemplate.send(USER_TOPIC, user);

    }

    public void sendAddressMessage(Object address) {
        logger.info(address.toString());
        this.kafkaTemplate.send(ADD_TOPIC,address);
    }
}
