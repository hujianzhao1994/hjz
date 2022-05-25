package com.jr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public Object test(){
        return "test";
    }

    @GetMapping("/err")
    public Object err(){
        int a  = 1/0;
        return a;
    }
}
