package com.miss.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =SpringApplication.run(GatewayApplication.class, args);
		String[] beans =configurableApplicationContext.getBeanDefinitionNames();
	}
}
