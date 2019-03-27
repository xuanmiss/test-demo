package com.miss.uc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/18
 */
@Component
public class LogTestHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    public Mono<String> testLog(ServerRequest serverRequest){
        String method = serverRequest.methodName();
        String params;
        params = serverRequest.queryParams().toString();
        logger.info("");
        return Mono.just("success");


    }
}
