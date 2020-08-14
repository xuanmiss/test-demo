package com.miss.uc;

import com.miss.uc.config.HttpsClientRequestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UcApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void testRestTemplate(){
        RestTemplate httpsrestTemplate = new RestTemplate(new HttpsClientRequestFactory());
        String ress = httpsrestTemplate.getForObject("https://www.baidu.com",String.class);
        System.out.println(ress);
        System.out.println("-------------");
        String res = restTemplate.getForObject("https://www.baidu.com",String.class);
        System.out.println(res);
    }

    @Test
    public void testAuthRestTemplate() {
        String url = "http://host";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+"a");
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        Map response = restTemplate.postForObject(url,httpEntity,Map.class);
        System.out.println(response.toString());
    }

}
