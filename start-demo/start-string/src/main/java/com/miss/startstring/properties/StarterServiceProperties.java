package com.miss.startstring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/29
 */

@ConfigurationProperties("example.service")
public class StarterServiceProperties {

    private String config;

    public void setConfig(String config){
        this.config = config;
    }

    public String getConfig(){
        return config;
    }
}
