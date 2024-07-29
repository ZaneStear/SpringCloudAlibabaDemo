package com.stear.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyCon {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String Add(){
        String s = restTemplate.getForObject("http://stock-s:8081/use", String.class);
        System.out.println(s);
        return "add";
    }
}
