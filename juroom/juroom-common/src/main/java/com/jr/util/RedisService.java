package com.jr.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public RedisService() {
    }

    public void setValue(String key, Object value) {
        ValueOperations<String, Object> vo = this.redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public void setValue(String key, Object value, long timeout) {
        ValueOperations<String, Object> vo = this.redisTemplate.opsForValue();
        vo.set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public boolean CheckRate(String key, long seconds) {
        long now = (new Date()).getTime();
        if (!this.contains(key)) {
            this.setValue(key, now, seconds * 1000L);
            return true;
        } else {
            try {
                long last = (Long)this.getValue(key);
                long lastTime = (now - last) / 1000L;
                if (lastTime > seconds) {
                    this.setValue(key, now, seconds * 1000L);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception var10) {
                return true;
            }
        }
    }

    public String getLock(List<String> list, long seconds) {
        Iterator var4 = list.iterator();

        String key;
        boolean lock;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            key = (String)var4.next();
            lock = this.getLock(key, seconds);
        } while(!lock);

        return key;
    }

    public boolean getLock(String key, long seconds) {
        long start = (new Date()).getTime();
        if (!this.contains(key)) {
            this.setValue(key, start, seconds * 1000L);
            return true;
        } else if (seconds == 0L) {
            return false;
        } else {
            try {
                boolean wait = true;

                do {
                    if (!wait) {
                        return false;
                    }

                    long lastTime = ((new Date()).getTime() - start) / 1000L;
                    if (lastTime > seconds) {
                        return false;
                    }

                    Thread.sleep(100L);
                } while(this.contains(key));

                this.setValue(key, start, seconds * 1000L);
                return true;
            } catch (Exception var9) {
                return false;
            }
        }
    }

    public <T> T getValue(String key) {
        ValueOperations<String, Object> vo = this.redisTemplate.opsForValue();
        return (T) vo.get(key);
    }

    public boolean contains(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public void delValue(String key) {
        this.redisTemplate.delete(key);
    }

    public long getExpire(String key) {
        return this.redisTemplate.getExpire(key);
    }

    public Long increment(String key, long delta) {
        return this.redisTemplate.opsForValue().increment(key, delta);
    }

    public Double increment(String key, double delta) {
        return this.redisTemplate.opsForValue().increment(key, delta);
    }
}
