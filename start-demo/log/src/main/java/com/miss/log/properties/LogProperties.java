package com.miss.log.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/29
 */
@ConfigurationProperties(prefix = "miss.log")
public class LogProperties {

    private String exclude;

    private String[] excludeArr;

    @PostConstruct
    public void init() {
        this.excludeArr = StringUtils.split(exclude, ",");
    }

    public String getExclude() {
        return exclude;
    }

    public String[] getExcludeArr() {
        return excludeArr;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

}
