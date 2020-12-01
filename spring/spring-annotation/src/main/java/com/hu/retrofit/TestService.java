package com.hu.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;

/**
 * @Description TODO
 * 业务Service应用类
 * @Author hjz
 * @Create 2020/12/1 9:52
 **/
@Service
public class TestService {



    @Autowired
    private HttpApi httpApi1;

    @Autowired
    HttpApi2 httpApi2;

    public Object listAll(){
        Object listAll = httpApi1.listAll();
        System.out.println(listAll);
        return listAll;
    }

    public Object retrofit(){
        Object listAll = httpApi1.retrofit("111");
        System.out.println(listAll);
        return listAll;
    }


}
