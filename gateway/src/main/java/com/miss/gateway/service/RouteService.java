package com.miss.gateway.service;

import com.miss.gateway.dao.RouteDao;
import com.miss.gateway.entity.Route;
import com.miss.gateway.utils.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/20
 */
@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    public List<Route> getRoutes() {
        return routeDao.getRoutes();
    }

    public void addRoute(Route route){
        routeDao.addRoute(route);
        ContextUtil.getBean(RouteLocator.class).getRoutes();
    }
}
