//package org.sz.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisService {
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public void set(String key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//
//    public Object get(String key) {
//        return redisTemplate.opsForValue().get(key);
//    }
//
//}