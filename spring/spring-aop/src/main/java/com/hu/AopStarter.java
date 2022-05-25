package com.hu;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableNacosDiscovery
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class AopStarter{

    public static void main(String[] args) {
        SpringApplication.run(AopStarter.class,args);
    }
}