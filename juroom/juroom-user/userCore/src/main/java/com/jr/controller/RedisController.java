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
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        for (int i = 0; i < 100; i++) {
            Long add = redisTemplate.opsForHyperLogLog().add(yyyyMMdd,i,20, TimeUnit.SECONDS);
            log.info("add:{}",add);
        }
        Long size = redisTemplate.opsForHyperLogLog().size(yyyyMMdd);
        Long union = redisTemplate.opsForHyperLogLog().union(yyyyMMdd, yyyyMMdd);
        log.info("size:{}",size);
        log.info("union:{}",union);
        return size;
    }

}
