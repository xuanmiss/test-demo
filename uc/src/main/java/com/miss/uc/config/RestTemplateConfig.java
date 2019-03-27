package com.miss.uc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/17
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
