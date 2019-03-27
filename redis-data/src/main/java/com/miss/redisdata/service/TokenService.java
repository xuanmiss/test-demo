package com.miss.redisdata.service;

import com.miss.redisdata.config.RedisConfig;
import com.miss.redisdata.dao.TokenDao;
import com.miss.redisdata.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/19
 */
@Service
public class TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    RedisConfig redisConfig;


    public Jedis getInstance(){
        Jedis jedis = new Jedis(redisConfig.getHost(),
                redisConfig.getPort());
        return jedis;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    public void addToken(Token token)
    {

        tokenDao.addToken(token);
    }

//

}
