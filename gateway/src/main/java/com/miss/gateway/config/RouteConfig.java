package com.miss.gateway.config;

import com.miss.gateway.dao.UserMapper;
import com.miss.gateway.entity.Route;
import com.miss.gateway.entity.User;
import com.miss.gateway.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/10/29
 */
@Configuration
public class RouteConfig {
    private static final Logger logger = LoggerFactory.getLogger(RouteConfig.class);

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserMapper userMapper;

    private List<Route> routes;



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder builderNew = builder.routes();
//        List<Route> routeList = routeService.getRoutes();
        this.routes = routeService.getRoutes();

        routes.stream()
                .forEach(each -> {
                            if(each.getCompanyCode() != null
                                    && !each.getCompanyCode().isEmpty()){
                                builderNew.route(route ->
                                        route.path(each.getPath())
//                                                .and()
//                                                .readBody(Object.class, requestBody -> {
//                                                    logger.info("requestBody is {}", requestBody);
//                                                    User user = new User();
//                                                    user.setAge(111);
//                                                    user.setName("gateway");
//                                                    userMapper.addUser(user);
//                                                    // 这里不对body做判断处理
//                                                    return true;
//                                                })
                                                .and()
                                                .order(each.getOrder())
                                                .header("company_code",each.getCompanyCode())
                                                .filters(f -> f.stripPrefix(0))
                                                .uri(each.getUrl()
                                                )
                                );
                            } else {
                                builderNew.route(route ->
                                                route.path(each.getPath())
                                                        .and()
                                                        .order(each.getOrder())
                                                        .header("company_code")
                                                        .filters(f -> f.stripPrefix(0))
                                                        .uri(each.getUrl())
                                        );
                            }
                }

                );
        return builderNew.build();

    }



}

