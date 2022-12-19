package com.maliitourist.apigestionregions.apigestionregions.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {
    @GetMapping("/dataTest")
    public Map<String,Object> datatest(){

        return Map.of("message", "Data test");
    }
}
