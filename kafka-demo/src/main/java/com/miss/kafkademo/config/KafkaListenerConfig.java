package com.miss.kafkademo.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import reactor.core.publisher.Flux;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */

@Configuration
@EnableKafka
public class KafkaListenerConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerConfig.class);



    @KafkaListener(id = "group1",topics = "users")
    public void userConsume(ConsumerRecord<?,?> record) {
        logger.info(record.toString());
        logger.info("User Consumer : ###" + record.value());

    }



    @KafkaListener(id = "group2",topics = "address")
    public void addressConsume(ConsumerRecord<?,?> record) {
        logger.info("Address Consumer : ###" + record.value());
    }

    @KafkaListener(id = "log_group1",topics = "userlog")
    public void userLogConsume(ConsumerRecord<?,?> record) {
        System.out.println("*****receive :"+record.value().toString());
    }

}
