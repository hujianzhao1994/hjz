package com.hu.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;


/**
 * @Description TODO
 * @Author hjz
 * @Create 2020/11/23 16:04
 **/



//  https://segmentfault.com/a/1190000019090635
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication
public class AnnocationStar {

    public static void main(String[] args) {
        SpringApplication.run(AnnocationStar.class,args);
    }
}
