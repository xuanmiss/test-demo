package com.miss.gateway.dao;

import com.miss.gateway.entity.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/20
 */
@Mapper
@Repository
public interface RouteDao {

    @Select("select * from route_definition")
    List<Route> getRoutes();

    @Insert("insert into route_definition(path,company_code,url) values(#{path},#{companyCode},#{url})")
    void addRoute(Route route);
}
