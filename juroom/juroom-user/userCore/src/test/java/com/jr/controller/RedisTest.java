package com.jr.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;


    // https://www.modb.pro/db/183137
    @Test
    public void testUnion(){

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

    }

    // 统计指定日期范围内的uv
    public long calculateUV(LocalDate start, LocalDate end) {
        // 整理该日期范围内的key
        List<String> keyList = new ArrayList<>();
        while (!start.isAfter(end)) {
            String key = String.format(start.toString());
            keyList.add(key);
            start = start.plusDays(1);
            redisTemplate.opsForHyperLogLog().add(key,start);
            redisTemplate.expire(key,5,TimeUnit.MINUTES);
        }

        // 合并这些日期内的数据
        String redisKey = String.format("union:%s:%S", start, end);
        Long size = redisTemplate.opsForHyperLogLog().size(redisKey);
        log.info("size-----"+size);
        String join = StringUtils.join(keyList.toArray(new String[0]));

        Long union1 = redisTemplate.opsForHyperLogLog().union(redisKey, join);
        log.info("join 的  字符串 一共数量-----"+union1);
        String[] array = keyList.toArray(new String[0]);
        Long union = 0L;
        redisTemplate.opsForHyperLogLog().add("2022-08-08",start.plusDays(10));
        union = redisTemplate.opsForHyperLogLog().union(redisKey,"2022-08-18");
        for (String arr: array) {
            union = redisTemplate.opsForHyperLogLog().union(redisKey,arr);
        }

        log.info("redisKey union-----"+union);

        Long size1 = redisTemplate.opsForHyperLogLog().size(redisKey);
        log.info("redisKey size1-----"+size1);
        // 返回统计后的结果
        return size1;

    }
}
