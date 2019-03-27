package com.miss.zkdemo.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/26
 */
@RestController
@RequestMapping("zk")
public class ZkTestController {

    @GetMapping(value = "/zkget" )
    public String zkget() {
        Watcher watcher= new Watcher(){
            public void process(WatchedEvent event) {
                System.out.println("receive event："+event);
            }
        };

        String value = null;
        try {
            final ZooKeeper zookeeper = new ZooKeeper("10.211.55.8:30048", 999999, watcher);
            final byte[] data = zookeeper.getData("/test", watcher, null);
            value = new String(data);
            zookeeper.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return "get value from zookeeper [" + value + "]";
    }
}
