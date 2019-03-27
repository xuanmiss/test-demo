package com.miss.uc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/12/18
 */
@Configuration
@EnableAsync
@Transactional
public class TaskAsync {

    private static final Logger logger = LoggerFactory.getLogger(TaskAsync.class);



    @Async
    public Future<String> doLog(){
        int i = 0;
        boolean flag = true;

        while (flag){
            try{
                TimeUnit.SECONDS.sleep(i++);
                logger.info("-----"+i);
                if(i >=5)
                {
                    flag = false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new AsyncResult<>("task complate");
    }
}
