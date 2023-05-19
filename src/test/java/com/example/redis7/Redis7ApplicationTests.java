package com.example.redis7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;

@SpringBootTest
class Redis7ApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        ValueOperations<String,String>operations =redisTemplate.opsForValue();
   //  Set<String> set =operations.get("*");
       operations.set("k8","8");
    String value=   operations.get("k8");
        System.out.println(value);

    }

}
