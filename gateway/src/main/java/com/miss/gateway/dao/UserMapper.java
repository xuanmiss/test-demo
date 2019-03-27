package com.miss.gateway.dao;

import com.miss.gateway.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * Created By peishengzhang
 * <p>
 * At 2018/10/12
 */
@Mapper
@Repository
public interface UserMapper {

//    @Results({
//            @Result(property = "name",column = "user_name",javaType = String.class,jdbcType = JdbcType.CLOB)
//    })
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);
//    @Select("select * from user")
//    List<User> getUserList();

    @Insert("insert into user(name,age,create_date,phone) values (#{name},#{age},#{createDate},#{phone})")
    void addUser(User user);

//    @Insert("insert into sys_user(name) values(#{name,jdbcType=CLOB})")
//    void addUser(User user);
}
