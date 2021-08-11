package com.hu.retrofit;

import com.hu.annotation.config.GookerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private GookerProperties gookerProperties;


    @GetMapping("/api1")
    public Object api1() {
        return testService.listAll();
    }


    @GetMapping("/api2")
    public Object api2() {
        return testService.listAll();
    }

    @GetMapping("/retrofit")
    public Object retrofit() {
        return testService.retrofit();
    }

    @GetMapping("/test")
    public void test() {
        System.out.println(gookerProperties.getCompanyName());
        System.out.println(gookerProperties.getPersonNum());
    }


}
