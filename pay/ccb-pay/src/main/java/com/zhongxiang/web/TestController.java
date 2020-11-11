package com.zhongxiang.web;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * 测试接口
 * @Author hjz
 * @Create 2020/11/9 9:30
 **/
@RestController
public class TestController {


    @GetMapping("/test")
    public Object test(){
        return "test";
    }
}
