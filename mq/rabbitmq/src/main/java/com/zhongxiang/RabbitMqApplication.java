package com.zhongxiang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * rabbitmq启动入口
 * @Author hjz
 * @Create 2020/10/21 14:17
 **/
@SpringBootApplication
public class RabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class,args);
    }
}
