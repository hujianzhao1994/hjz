package com.hu.notice.web;


import com.kc.exception.notice.annotation.ExceptionNotice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ExceptionNotice
    @GetMapping("/test")
    public Object test() throws IllegalAccessException {
        int i = 1/0;
        return  i;
        //throw new IllegalAccessException("参数异常");
    }


    @PostMapping("/postGet")
    public Object postGet(String username,String password){
        System.out.println(username+"----"+password);
        String a[] = new String[]{"a","b"};
        String bb = a[3];
        return username+"--"+password;
    }
}
