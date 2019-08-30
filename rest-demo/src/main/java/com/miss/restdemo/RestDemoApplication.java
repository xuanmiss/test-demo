package com.miss.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;


@EnableEurekaClient
@SpringBootApplication
@RestController
@RequestMapping
public class RestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDemoApplication.class, args);
    }

    @GetMapping("foo")
    public String foo(@RequestHeader("foo") String foo,
                      @RequestParam("test") String test){
        return "bar";
    }

}
