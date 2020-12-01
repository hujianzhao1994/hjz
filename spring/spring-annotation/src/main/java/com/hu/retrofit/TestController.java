package com.hu.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * 测试Retrofit
 * @Author hjz
 * @Create 2020/12/1 10:14
 **/
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/api1")
    public Object api1(){
        return testService.listAll();
    }


    @GetMapping("/api2")
    public Object api2(){
        return testService.listAll();
    }

    @GetMapping("/retrofit")
    public Object retrofit(){
        return testService.retrofit();
    }
}
