package com.miss.uc.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/30
 */

@Component
public class TimeHandler {

    public Mono<ServerResponse> getTime(ServerRequest serverRequest)
    {

        return ok().contentType(MediaType.APPLICATION_JSON).body
                (Mono.just("Now is "+ new SimpleDateFormat("HH:mm:ss").format(new Date())),String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest)
    {
        return ok().contentType(MediaType.APPLICATION_JSON).body
                (Mono.just("Now is "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())),String.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest)
    {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(  // 1
                Flux.interval(Duration.ofSeconds(1)).   // 2
                        map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
                String.class);
    }

    public Mono<ServerResponse> execTime(ServerRequest serverRequest)
    {
        System.out.println(System.currentTimeMillis());

        List<Integer> dateList = new ArrayList<>();
//        Calendar c = Calendar.getInstance();
        for(int i=0;i<20;i++)
        {
           dateList.add(i);
        }
        System.out.println(System.currentTimeMillis());
        Long beginTime = System.currentTimeMillis();
        dateList = dateList.stream().map(date -> {
            try{
                TimeUnit.SECONDS.sleep(date);
                System.out.println(System.currentTimeMillis()+"****"+date);
                return date*date;

            }catch (InterruptedException e)
            {
                e.printStackTrace();
                return date*date;
            }
            }
            ).collect(Collectors.toList());
//        dateList.stream().forEach(System.out::println);
        System.out.println(System.currentTimeMillis());
        Long endTime = System.currentTimeMillis();
        String resp = (endTime-beginTime)+"";

        return ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(resp),String.class);
    }

}
