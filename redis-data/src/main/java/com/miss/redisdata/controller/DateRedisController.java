package com.miss.redisdata.controller;

import com.miss.redisdata.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/19
 */
@RestController
public class DateRedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/addData")
    public Object addData(@RequestBody Token token){
        redisTemplate.opsForList().leftPush("token",token);

        return "success";
    }
}
