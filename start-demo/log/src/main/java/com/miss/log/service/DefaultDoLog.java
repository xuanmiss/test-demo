package com.miss.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/6/19
 */
@Service
public class DefaultDoLog implements DoLogAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDoLog.class);

    @Override
    public void doLog() {
        logger.info("this is default log operation");
    }
}
