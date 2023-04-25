package com.example.exam.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {
//    空指针报错的话需要这一段代码运行在redis客户端
//    config set stop-writes-on-bgsave-error no
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    /**
     * set redis: string类型
     * @param key key
     * @param value value
     */
    public void setString(String key, String value){
        System.out.println(redisTemplate);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }
    /**
     * get redis: string类型
     * @param key key
     * @return
     */
    public String getString(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
