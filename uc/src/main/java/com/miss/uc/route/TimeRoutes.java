package com.miss.uc.route;

import com.miss.uc.handler.TimeHandler;
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
 * At 2018/11/30
 */

@Configuration
public class TimeRoutes {

    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRoute() {
        return route(GET("/time"),req -> timeHandler.getTime(req))
                .andRoute(GET("/date"),timeHandler::getDate)
                .andRoute(GET("/times"),timeHandler::sendTimePerSec)
                .andRoute(GET("/execTime"),timeHandler::execTime);
    }
}
