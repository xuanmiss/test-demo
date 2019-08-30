package com.miss.statedemo;

import com.miss.statedemo.events.TurnstileEvents;
import com.miss.statedemo.states.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateDemoApplication implements CommandLineRunner {

    private final StateMachine<TurnstileStates,TurnstileEvents> stateMachine;

    @Autowired
    public StateDemoApplication(StateMachine<TurnstileStates, TurnstileEvents> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public static void main(String[] args) {
        SpringApplication.run(StateDemoApplication.class, args);
    }
    @Override
    public void run(String... strings) throws Exception {
        stateMachine.start();
        System.out.println("--- coin ---");
        stateMachine.sendEvent(TurnstileEvents.COIN);
        System.out.println("--- coin ---");
        stateMachine.sendEvent(TurnstileEvents.COIN);
        System.out.println("--- push ---");
        stateMachine.sendEvent(TurnstileEvents.PUSH);
        System.out.println("--- push ---");
        stateMachine.sendEvent(TurnstileEvents.PUSH);
        stateMachine.stop();
    }


}
