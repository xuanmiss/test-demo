package com.miss.uc.route;

import com.miss.uc.handler.TestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/12/18
 */

@Configuration
public class TestRoutes {

    @Autowired
    private TestHandler testHandler;
    @Bean
    public RouterFunction<ServerResponse> testRoute(){
        return route(POST("/test"),testHandler::testTask);
    }
}
