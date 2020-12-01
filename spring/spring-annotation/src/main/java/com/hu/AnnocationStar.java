package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
