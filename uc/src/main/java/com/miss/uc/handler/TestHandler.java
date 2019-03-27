package com.miss.uc.handler;

//import com.definesys.mpaas.query.MpaasQueryFactory;
import com.miss.uc.config.TaskAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/12/18
 */

@Component
public class TestHandler {

    @Autowired
    private TaskAsync taskAsync;


//    private MpaasQueryFactory sw;
    public Mono<ServerResponse> testTask(ServerRequest serverRequest){
//
//        Future<String> task =  taskAsync.doLog();
//
//        String result = "error";
//        if(task.isDone()){
//            result = "success";
//        }
//        List<Map> res = new ArrayList<>();
//        res = sw.buildQuery()
//                .sql("SELECT\n" +
//                        "\t( SELECT COUNT ( 1 ) FROM USER u WHERE u.phone = '10086' ) AS COUNT,\n" +
//                        "\tu1.* \n" +
//                        "FROM\n" +
//                        "\tUSER u1 \n" +
//                        "WHERE\n" +
//                        "\tu1.id = 1")
//                .doQuery(Map.class);
        Mono<String> bodys= serverRequest.bodyToMono(String.class);

        Mono<String>rest = bodys.map(str ->{
            System.out.println(str);
            return str;
        });
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(rest,String.class);
    }

}
