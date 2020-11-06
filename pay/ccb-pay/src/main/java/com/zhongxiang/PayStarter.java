package com.zhongxiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;

/**
 * @Description TODO
 * 启动类
 * @Author hjz
 * @Create 2020/11/6 14:46
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PayStarter {

//    public static void main(String[] args) {
//        SpringApplication.run(PayStarter.class,args);
//    }
}
