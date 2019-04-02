package com.miss.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication
@RestController
@RequestMapping("")
@EnableScheduling
public class HelloApplication {

    private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @GetMapping("/hello/{name}")
    public String hello( @PathVariable("name") String name,
                         @RequestParam("times") int times){
        for(int i = 0; i < times; i++) {
            logger.info("i === name is : " + name);
        }
        return "hello world :"+name;
    }

    @Scheduled(cron = "* * * * * ?")
    public void teseLog() {
        logger.info(new Date().toString());
    }

}
