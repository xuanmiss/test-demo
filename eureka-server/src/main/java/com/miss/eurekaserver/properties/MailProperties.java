package com.miss.eurekaserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/9
 */

@Component
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    private String from;

    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}