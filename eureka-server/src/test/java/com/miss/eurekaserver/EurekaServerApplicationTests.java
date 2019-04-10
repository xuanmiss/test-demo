package com.miss.eurekaserver;

import com.miss.eurekaserver.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMail(){
        mailService.sendSimpleMail("xuanmine@gmail.com","Spring Mail test","this is a test mail");
    }


}
