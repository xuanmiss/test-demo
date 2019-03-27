package com.miss.log.config;

import com.miss.log.annotation.SysLog;
import com.miss.log.properties.LogProperties;
import com.miss.log.service.LogMethodInterceptor;
import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/29
 */
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration extends AbstractPointcutAdvisor {

    private Logger logger = LoggerFactory.getLogger(LogAutoConfiguration.class);

    private Pointcut pointcut;

    private Advice advice;

    @Autowired
    private LogProperties logProperties;

    @PostConstruct
    public void init() {
        logger.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, SysLog.class);
        this.advice = new LogMethodInterceptor(logProperties.getExcludeArr());
        logger.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
