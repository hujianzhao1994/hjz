package com.hu.notice.web;


import com.hu.notice.common.RetData;
import com.hu.notice.service.ITestService;
import com.hu.notice.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ITestService iTestService;

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

    @PostMapping("/login")
    public Object login(String username,String password){
        RetData retData = iTestService.login(username,password);
        return username+"--"+password;
    }


    @PostMapping("/loginVo")
    public Object loginVo(LoginVo loginVo){
        RetData retData = iTestService.login(loginVo);
        return  retData;
    }
}
