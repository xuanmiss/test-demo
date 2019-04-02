package com.miss.kafkademo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */
@Component
public class UserHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserHandler.class);

    public Mono<ServerResponse> senUserInfo(ServerRequest serverRequest) {

        int i = 0;
        logger.info(""+(i++));

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.interval(Duration.ofSeconds(1))
                        .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                        .map(data -> ServerSentEvent.<Integer>builder()
                                .event("random")
                                .id(Long.toString(data.getT1()))
                                .data(data.getT2())
                                .build()
                        ),ServerSentEvent.class);

    }
}
