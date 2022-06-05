package com.hu.securitydemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 测试
     *
     * @return {@link Object}
     */
    @GetMapping("/test")
    public Object test(){
        return "test";
    }
}
