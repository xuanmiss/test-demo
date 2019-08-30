package com.miss.log.service;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/29
 */
public class LogMethodInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogMethodInterceptor.class);

    private List<String> exclude;

    @Autowired
    private DoLogAdapter doLogAdapter;

    public LogMethodInterceptor(String[] exclude) {
//
        if(exclude == null){
            exclude = new String[]{""};
        }
        this.exclude = Arrays.asList(exclude);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String methodName = methodInvocation.getMethod().getName();
//        获取Param的name
//        String paramName = methodInvocation.getMethod().getParameters()[0].getName();
        Object[] parameters = methodInvocation.getArguments();
        String params = "";
        for(Object parameter : parameters){
            params += parameter.toString();
        }
        if(exclude.contains(methodName)) {
            return methodInvocation.proceed();
        }
        Long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        Long end = System.currentTimeMillis();
        logger.info("======method({}), params({}), cost({}) ",methodName,params,(end - start));
        doLogAdapter.doLog();
        return result;
    }
}
