package com.miss.uc.handler;

import com.miss.uc.annotation.SysLog;
import com.miss.uc.dao.UserMapper;
import com.miss.uc.entity.SysUser;
import com.miss.uc.entity.User;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/10/12
 */
@Component
public class UserHandler {

    @Autowired
    private UserMapper userMapper;

    @SysLog(content = "获取用户列表")
    public Mono<ServerResponse> getUsers(ServerRequest serverRequest){

        Flux<User> res = Mono.just(userMapper.getUsers()).flatMapMany(Flux::fromIterable);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(res,User.class);
    }

    @SysLog(content = "根据ID获取用户")
    public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
        Integer queryId = serverRequest.queryParam("id")
                                        .map(id -> Integer.valueOf(id))
                                        .get();
        User res = userMapper.getUserById(queryId);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(res),User.class);
    }

    @SysLog(content = "新增用户")
    public Mono<ServerResponse> addUsers(ServerRequest serverRequest){
//        User user = new User(6,"ppp",10,new Date(),"111111");
        Mono<Map> userMono = serverRequest.bodyToMono(Map.class);

//        User userq = userMono.block();
//        System.out.println(userq.toString())
     Mono<Map> res = userMono.map(user -> {
                                        userMapper.addUser(user);
                                        System.out.println(user.toString());
                                        return new HashMap(){{
                                            put("code",200);
                                            put("message","success");
                                        }} ;
                                    }
                                    );
//        Mono<User> nUser = Mono.just(user);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(res,Map.class);
    }
}
