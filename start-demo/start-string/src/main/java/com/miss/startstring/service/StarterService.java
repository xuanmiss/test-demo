package com.miss.startstring.service;

import org.springframework.util.StringUtils;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/29
 */
public class StarterService {

    private String config;

    public StarterService(String config){
        this.config = config;
    }

    public String[] split(String separatorChar){
        return StringUtils.split(this.config,separatorChar);
    }
}
