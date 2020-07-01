package com.example.demo;

import com.example.demo.webservice.client.MESTSP;
import com.example.demo.webservice.client.MESTSPSoap;
import org.junit.Test;

public class WSTest {
    @Test
    public void test5() {
        MESTSP mestsp = new MESTSP();
        MESTSPSoap mestspSoap = mestsp.getMESTSPSoap();
        String data = "[{\"vin\":\"SGHJ9876545676546\",\"CheckRsult\":\"Y\",\"CheckTime\":\"2020-10-10 10:10:10\"}]";
//        String data = "{\"vin\":\"SGHJ9876545676546\",\"CheckRsult\":\"Y\",\"CheckTime\":\"2020-10-10 10:10:10\"}";
        String tboxData = mestspSoap.getTboxData(data);
        System.out.println("tboxData = " + tboxData);
    }
}
