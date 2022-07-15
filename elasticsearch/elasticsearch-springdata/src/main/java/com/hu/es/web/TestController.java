package com.hu.es.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class TestController {


    @GetMapping("/test")
    public Object test(){
        log.info("this is Test,---{}", LocalDateTime.now());
        //int i  = 1/0 ;
        return "test";
    }

    @GetMapping("/err")
    public Object err(){
        int i  = 1/0 ;
        return "err";
    }
}
