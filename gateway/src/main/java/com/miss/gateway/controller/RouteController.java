package com.miss.gateway.controller;

import com.miss.gateway.config.RouteConfig;
import com.miss.gateway.entity.Route;
import com.miss.gateway.service.RouteService;
import com.miss.gateway.utils.ContextUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/20
 */
@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/addRoute")
    public Object addRoute(@RequestBody Route route){
        routeService.addRoute(route);
        return "success";
    }

    @GetMapping("/getRoutes")
    public Object getRoutes() {
        return routeService.getRoutes();

    }
//
//    @GetMapping("/refresh")
//    public String refresh(){
//        ContextUtil.getBean("RouteLocator").getClass().
//    }


}
