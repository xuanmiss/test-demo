package com.miss.eurekaserver.config;

import com.miss.eurekaserver.properties.MailProperties;
import com.miss.eurekaserver.service.MailService;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created By peishengzhang
 * <p>
 * At 2019/4/9
 */
@Component
public class EurekaStateChangeListener {

    private static final Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);

    private final MailService mailService;
    private final MailProperties mailProperties;

    @Autowired
    public EurekaStateChangeListener(MailService mailService,MailProperties mailProperties) {
        this.mailService = mailService;
        this.mailProperties = mailProperties;
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        logger.info(appName);
        logger.info(serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) throws IllegalAccessException{
        InstanceInfo instanceInfo = event.getInstanceInfo();
        Map instance = new HashMap();
        Field[] fields = InstanceInfo.class.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            instance.put(field.getName(),field.get(instanceInfo));
        }
        mailService.sendSimpleMail(mailProperties.getTo(),"Service Registe",instance.toString());

        logger.info(instance.toString());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {

    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        String subject = "Eureka Start At ";
//        Timestamp ts = new Timestamp(event.getTimestamp());
        String time = new Date().toString();
        String source = event.getSource().toString();
        logger.info(time,event.getSource());
//        mailService.sendSimpleMail(mailProperties.getTo(),subject+time,source);
    }
}
