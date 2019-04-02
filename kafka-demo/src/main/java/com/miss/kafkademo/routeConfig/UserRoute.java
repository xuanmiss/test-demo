package com.miss.kafkademo.routeConfig;

import com.miss.kafkademo.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */
@Configuration
public class UserRoute {

    private final UserHandler userHandler;

    @Autowired
    UserRoute (UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> usersRoute() {
        return route(GET("/user/test"),userHandler::senUserInfo);
    }
}
