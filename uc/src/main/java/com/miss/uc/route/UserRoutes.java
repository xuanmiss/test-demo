package com.miss.uc.route;

import com.miss.uc.handler.UserHandler;
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
 * At 2018/10/12
 */
@Configuration
public class UserRoutes {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> userRoute(){

       return route(GET("/user/list"),userHandler::getUsers)
               .andRoute(POST("/user/add"),userHandler::addUsers)
               .andRoute(GET("/user/findById"),userHandler::getUserById);
    }
}
