package com.example.demo;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class WSTest {
    @Test
    public void test5() throws InterruptedException {
        System.out.println(" sleep . . . .");
        Thread.sleep(10000);
        HashMap<Object, Object> map = new HashMap<>();
        while (true) {
            String str = UUID.randomUUID().toString() + new Date().toLocaleString();
            map.put(UUID.randomUUID().toString(), str);
            System.out.println("map = " + map.size());
            if (map.size() % 100000 == 0) {
                System.out.println(" sleep . . . .");
                Thread.sleep(1000);
            }
        }
    }
}
