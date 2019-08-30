package com.miss.feigndemo.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/10
 */
@Configuration
public class FeignNewConfig {
    @Bean
    public RequestInterceptor requestNewInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("foo1","foo1");
        };
    }
}
