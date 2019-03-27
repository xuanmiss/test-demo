package com.miss.uc.aop;

import com.miss.uc.annotation.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.reactive.result.view.RequestContext;

import java.lang.reflect.Method;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/10/30
 */
@Aspect
@Component
public class SysLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);


    @Pointcut("execution(public * com.miss.uc.handler.*.*(..))")
    public void weblog(){}

    @Before("weblog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable
    {
        logger.debug("开始执行日志记录");

        //获得切面当中方法签名
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //获得签名方法
        Method method = methodSignature.getMethod();
        //获得在方法上面的注解
        SysLog sysOptLog =  method.getAnnotation(SysLog.class);
        if(sysOptLog == null) return;

        // 接收到请求，记录请求内容
//       RequestAttributes attributes =  RequestContextHolder.getRequestAttributes();

//        request.getSession().getId()
        logger.info(sysOptLog.content());
        logger.debug("日志记录完成");
    }



}
