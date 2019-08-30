package com.miss.shellfirstdemo.command;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By peishengzhang
 * <p>A Class With Math Command In Shell
 * At 2019/1/29
 */

@ShellComponent
public class MathCommand {

    @ShellMethod(value = "Add two integers together",key = {"sum","add"})
    public int add(int a, int b){
        return a + b;
    }

    @ShellMethod(value = "test Map integer",key = {"map"})
    public int mapTest(int a){

        Map map = new HashMap();
        if(a<10) {
            map.put("times", a);
        }
        return map.get("times")==null?0:(int)map.get("times");
    }

    @ShellMethod(value = "test Map String ",key = {"strMap"})
    public String mapStrTest(String str,String key){
        Map map = new HashMap();
        map.put("hello","world");
        return str+map.get(key);
    }

    @ShellMethod(value = "md5 加密",key = {"md5"})
    public String md5(String str, int length) {
        String res = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            BASE64Encoder bw = new BASE64Encoder();
             res = bw.encode(md.digest(str.getBytes("utf-8")));
           return res;

        }catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }

    @ShellMethod(value = "map str",key = {"mapstr"})
    public String mapStr() {
        Map map = new HashMap();
       if(map.isEmpty()){
           return "空的map";
       }else {
           return map.toString();
       }
    }



}
