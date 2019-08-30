package com.miss.statedemo.route;

import com.miss.statedemo.handler.StileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/11
 */
@Configuration
public class StileRoute {

    private final StileHandler stileHandler;

    @Autowired
    public StileRoute(StileHandler stileHandler) {
        this.stileHandler = stileHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> coinPushStile() {

        return route(GET("/coin"),stileHandler::stileCoin)
                .andRoute(GET("/push"),stileHandler::stilePush);
    }
}
