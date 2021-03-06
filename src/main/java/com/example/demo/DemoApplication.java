package com.example.demo;

import com.example.demo.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
@RestController
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/")
    public Object start() {
        return "Hello World";
    }

    @RequestMapping("/hello")
    public Object hello(String name) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("ip", IpUtil.getLocalIpByNetcard());
        map.put("time", new Date().toLocaleString());
        return map;
    }

    @RequestMapping("/time")
    public Object time() {
        return new Date().toLocaleString();
    }

}
