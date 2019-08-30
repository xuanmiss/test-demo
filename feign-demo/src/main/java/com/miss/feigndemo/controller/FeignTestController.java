package com.miss.feigndemo.controller;

import com.miss.feigndemo.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/9
 */
@RestController
@RequestMapping("feigndemo")
public class FeignTestController {

    private final RestClient restClient;

    @Autowired
    public FeignTestController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("test")
    public String foo() {
        return restClient.foo("test");
    }
}
