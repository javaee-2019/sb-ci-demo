package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

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
    public Object hello(HttpServletRequest request) {
        String url = getUrl();
        String ipAddress = getIPAddress(request);
        log.info("{}==>{}", ipAddress, url);
        return ipAddress + "===>" + url + "====>" + new Date().toLocaleString();
    }

    @RequestMapping("/time")
    public Object time() {
        return getUrl() + "====>" + new Date().toLocaleString();
    }


    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://" + address.getHostAddress();
    }

    public String getIPAddress(HttpServletRequest request) {
        try {
            String remoteAddress = "";
            if (request != null) {
                remoteAddress = request.getHeader("X-Forwarded-For");
                if (remoteAddress == null || "".equals(remoteAddress)) {
                    remoteAddress = request.getRemoteAddr();
                }
            }
            remoteAddress = remoteAddress != null && remoteAddress.contains(",") ? remoteAddress.split(",")[0] : remoteAddress;
            return remoteAddress;
        } catch (Exception e) {
            return null;
        }
    }
}
