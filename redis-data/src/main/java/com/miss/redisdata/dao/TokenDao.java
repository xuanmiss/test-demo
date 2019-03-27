package com.miss.redisdata.dao;

import com.miss.redisdata.entity.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/19
 */
@Repository
@Mapper
public interface TokenDao {

    @Insert("insert into token (key,value,expire_time,created_by,creation_date)values(#{key},#{value},#{expireTime},#{createdBy},#{creationDate})")
    void addToken(Token token);
}
