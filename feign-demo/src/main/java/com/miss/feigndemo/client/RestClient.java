package com.miss.feigndemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/9
 */
@FeignClient(name = "rest-demo",path = "")
public interface RestClient {

    @RequestMapping(value = "/foo",method = RequestMethod.GET)
    String foo();
}
