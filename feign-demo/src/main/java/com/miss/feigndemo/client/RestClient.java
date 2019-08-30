package com.miss.feigndemo.client;

//import com.miss.feigndemo.config.FeignConfig;
import com.miss.feigndemo.config.FeignNewConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/9
 */
@FeignClient(name = "rest-demo",path = "",configuration = FeignNewConfig.class)
public interface RestClient {

    @RequestMapping(value = "/foo",method = RequestMethod.GET)
    String foo(@RequestParam("test") String test);
}
