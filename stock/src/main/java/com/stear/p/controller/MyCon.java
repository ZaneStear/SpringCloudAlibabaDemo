package com.stear.p.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCon {

    @RequestMapping("/use")
    public String Add(){
        return "stock";
    }
}
