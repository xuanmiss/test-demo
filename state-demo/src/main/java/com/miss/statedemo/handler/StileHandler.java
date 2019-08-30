package com.miss.statedemo.handler;

import com.miss.statedemo.events.TurnstileEvents;
import com.miss.statedemo.states.TurnstileStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/11
 */
@Component
public class StileHandler {

    private static final Logger logger = LoggerFactory.getLogger(StileHandler.class);

    private final StateMachine<TurnstileStates,TurnstileEvents> stateMachine;

    @Autowired
    public StileHandler(StateMachine<TurnstileStates, TurnstileEvents> stateMachine) {
        this.stateMachine = stateMachine;
    }


    public Mono<ServerResponse> stileCoin(ServerRequest serverRequest) {

        stateMachine.sendEvent(TurnstileEvents.COIN);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("coin"),String.class);

    }

    public Mono<ServerResponse> stilePush(ServerRequest serverRequest) {
        stateMachine.sendEvent(TurnstileEvents.PUSH);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("push"),String.class);
    }

}
