package com.miss.gateway.filters;

import com.miss.gateway.dao.UserMapper;
import com.miss.gateway.entity.User;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.DefaultServerRequest;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/12/19
 */
@Component
public class PreFilter implements GlobalFilter,Ordered {
    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        Object reqestBody = exchange.getAttribute("cachedRequestBodyObject");
//        logger.info(reqestBody.toString());

        logger.info(Thread.currentThread().getName());
        String requestPayLoad = "";
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        ServerHttpRequest serverHttpRequest = request;
        if ("POST".equals(method)) {
//            Map attributes = exchange.getAttributes();
//            logger.info(attributes.toString());
//            Object requestBody = exchange.getAttribute("cachedRequestBodyObject");
//            requestPayLoad = resolveBodyFromRequest(request,exchange);
//            requestPayLoad = requresMap.get("string").toString();
//            logger.info("requestPayloag is {} and length is {}",requestPayLoad,requestPayLoad.length());
//            URI nuri = request.getURI();
//            serverHttpRequest= request.mutate().uri(nuri).build();
//            DataBuffer bodyDataBuffer = stringBuffer(requestPayLoad);
//            Flux<DataBuffer> bodyFlux = Flux.just(stringBuffer(requestPayLoad));
//            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
//            serverHttpRequest = new ServerHttpRequestDecorator(serverHttpRequest) {
//                @Override
//                public Flux<DataBuffer> getBody() {
//                    return bodyFlux;
//                }
//
//            };


//        return chain.filter(exchange.mutate().request(serverHttpRequest).build()).then(Mono.fromRunnable(()->{logger.info("123456");}));
            return chain.filter(resolveBodyFromRequest(exchange))
                    .then(Mono.fromRunnable(() -> {
                                Map attributes = exchange.getAttributes();
                                logger.info(attributes.toString());
                                Object reqBody = exchange.getAttributes().get("zpsreq");
                                logger.info("zps reqBody is {}",reqBody.toString());
//                                Flux<DataBuffer> reqBodyBufferFlux = exchange.getAttribute("zpsreq");
                                //            exchange.getAttributes().remove()
//                                AtomicReference<String> bodyRef = new AtomicReference<>();
//                                Flux<String> strFlux = reqBodyBufferFlux
//                                        .flatMap(buffer -> {
//                                            logger.info("reqbuffer size" + buffer.readableByteCount() + System.currentTimeMillis());
//                                            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
//                                            logger.info("reqcharbuffer size" + charBuffer.length() + System.currentTimeMillis());
//                                            DataBufferUtils.release(buffer);
//                                            bodyRef.set(charBuffer.toString());
//                                            logger.info("string is {}", bodyRef.get());
//
//                                            return Flux.just(bodyRef.get());
//                                        });
                            })
                    )
                    ;
        }
        return chain.filter(exchange);
    }

    private ServerWebExchange resolveBodyFromRequest(ServerWebExchange exchange) {
        //获取请求体
        ServerRequest serverRequest = new DefaultServerRequest(exchange);
        Mono<String> requestbody = serverRequest.bodyToMono(String.class);

        AtomicReference<String> bodyRef = new AtomicReference<>();
//        requestbody.subscribe(bodyString -> {
//            logger.info("Mono 中的 String is {}",bodyString);
//            bodyRef.set(bodyString);
//            exchange.getAttributes().put("reqBody",bodyString);
//
//        });
//        final boolean  flag = true;
//        Mono<List<DataBuffer>> body = serverHttpRequest
//                .getBody()
//                .collectList()
//                ;

        Flux<DataBuffer> cachedFlux = requestbody.flux().flatMap(bodyString -> {
            exchange.getAttributes().put("zpsreq",bodyString);
            return Flux.just(stringBuffer(bodyString));
        });
//        Flux<DataBuffer> attrFlux = cachedFlux;
        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public Flux<DataBuffer> getBody() {
                return cachedFlux;
            }
        };
//        exchange.getAttributes().put("zpsreq",attrFlux);

////        AtomicReference<String> bodyRef = new AtomicReference<>();
////        final String[]res = {""};
////
////
////        body.subscribe(bufferList -> {
////            for(DataBuffer buffer : bufferList)
////            {
////                logger.info("cachebuffer size"+buffer.readableByteCount()+"  time  "+System.currentTimeMillis());
////                AtomicReference<String> bodyRef = new AtomicReference<>();
////                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
////                DataBufferUtils.release(buffer);
////                bodyRef.set(charBuffer.toString());
////                res[0]+=bodyRef.get();
////                logger.info(res[0]);
////            }
//            logger.info("cachebuffer size"+buffer.readableByteCount()+System.currentTimeMillis());
//            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
//            logger.info("charbuffer size"+charBuffer.length()+System.currentTimeMillis());
//            DataBufferUtils.release(buffer);
//            bodyRef.set(charBuffer.toString());
//            logger.info("string is {}",bodyRef.get());
//        });

//        return bodyRef.get();
//        获取request body

        return exchange.mutate().request(mutatedRequest).build() ;
    }
    private DataBuffer stringBuffer(String value) {
        byte[] bytes;
        if(value != null && !value.trim().equals("")) {
            bytes = value.getBytes(StandardCharsets.UTF_8);
        }else{
            bytes = new byte[0];
        }
        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);

        buffer.write(bytes);
        return buffer;


    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
