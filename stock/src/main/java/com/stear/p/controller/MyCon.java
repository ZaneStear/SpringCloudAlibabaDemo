package com.stear.p.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCon {

    @Value("${server.port}")
    String port;

    @RequestMapping("/use")
    public String use(){
        return "stock " + port + " used";
    }
}
