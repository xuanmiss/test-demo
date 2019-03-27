package com.miss.taskdemo;

import com.miss.log.annotation.SysLog;
import com.miss.startstring.service.StarterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/1/18
 */
@RestController
@RequestMapping("/")
public class TestStartStringController {

    private static final Logger logger = LoggerFactory.getLogger(TestStartStringController.class);

    @Autowired
    private StarterService starterService;

    @GetMapping("/test")
    @SysLog
    public List<String> TestString(@RequestParam("name")String name){
        String[] strs = starterService.split(",");
        logger.info(name);
        return Arrays.asList(strs);
    }

    @GetMapping("/testString")
    public List<String> TestStringLocal(){
        String[] strs = StringUtils.split("abc-des-dde,SSS-DRS-RE,SDR-SDFR-XXX",",");
        return Arrays.asList(strs);
    }
}
