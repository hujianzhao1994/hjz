package com.jr.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class RedisController {


    @Autowired
    private RedisTemplate redisTemplate;

    // https://www.cxymm.net/article/boxrq1/114686938
    @GetMapping("/getUV")
    public Object getUV(HttpServletRequest request){

        /**
         *  统计日活跃，月活
         *
         *  日活： 以IP为唯一标识，  key= 当天+页面名称,value=IP
         */

        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key1 = yyyyMMdd +"_"+ "index.html";
        String[] ipList = new String[]
                {
                        "192.169.18.1",
                        "192.169.18.2",
                        "192.169.18.3",
                        "192.169.18.4",
                        "192.169.18.5",
                        "192.169.18.6",
                        "192.169.18.2",
                        "192.169.18.2"
                };
        redisTemplate.opsForHyperLogLog().add(key1,ipList);
        redisTemplate.expire(key1,60, TimeUnit.SECONDS);
        // 返回集合数量
        Long size = redisTemplate.opsForHyperLogLog().size(key1);
        log.info("size-----"+size);

        String[] ipList2 = new String[]
                {
                        "192.169.18.7",
                        "192.169.18.8",
                        "192.169.18.9",
                        "192.169.18.10",
                        "192.169.18.8",
                        "192.169.18.8",
                        "192.169.18.8",
                        "192.169.18.8",
                        "192.169.18.7"
                };

        String key2 = yyyyMMdd +"_"+ "detail.html";
        redisTemplate.opsForHyperLogLog().add(key2,ipList2);
        redisTemplate.expire(key2,60, TimeUnit.SECONDS);

        // 返回集合数量
        Long size2 = redisTemplate.opsForHyperLogLog().size(key2);
        log.info("size2-----"+size2);

        // 所有集合 合计
        Long unionCnt = redisTemplate.opsForHyperLogLog().union("unionKey",key1,key2);
        log.info("unionKey-----"+unionCnt);

        //redisTemplate.opsForHyperLogLog().delete(key1);  //删除redis key
        return 0;
    }


}
