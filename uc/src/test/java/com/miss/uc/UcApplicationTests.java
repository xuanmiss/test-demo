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
        String url = "http://ripplescloud.dev.crpharm.com/apis/mgt/security/getLoginData";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJrZXlfdmVyc2lvbiI6IjAwMSIsInVzZXJfcmVwb3NpdG9yeSI6IlVDMDAwMSIsInVzZXJfbmFtZSI6ImJ4MSIsInNjb3BlIjpbIlNDT1BFX09ORSIsIlNDT1BFX1RXTyJdLCJleHAiOjE1NTM1MDcwMzgsInByb2RfY29kZSI6Ik1TUCIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwianRpIjoiM2YzYTk2NDQtZWY2Yy00ZmVmLTg5ZWItOGJlZWQxZTliZTRlIiwiY2xpZW50X2lkIjoiTVNQLmRjcGMiLCJ0ZW5hbnRfY29kZSI6ImRjcGMifQ.-QJ0LZXLm_86Z-Kx_ZOC0MlFAQxM5eEfsryyNTT8V1U");
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        Map response = restTemplate.postForObject(url,httpEntity,Map.class);
        System.out.println(response.toString());
    }

}
