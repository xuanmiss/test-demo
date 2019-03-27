package com.miss.redisdata;

import com.miss.redisdata.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RedisDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDataApplication.class, args);
    }

    @Autowired
    private RedisTemplate redisTemplate;
    @PostConstruct
    public void tokenCustom()
    {
        while (true){
            Token value  = (Token)redisTemplate.opsForList()
                    .rightPop("token",100, TimeUnit.DAYS);
            System.out.println(value.toString());

        }
    }
}
