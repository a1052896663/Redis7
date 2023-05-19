package com.example.redis7.server;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Setter
@Slf4j
public class OrederService {
    public static  final  String ORDER_KEY="ord:";
    @Resource
    private RedisTemplate redisTemplate;

    public void addOrder(){
        int keyID= ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo= UUID.randomUUID().toString();

        String key=ORDER_KEY+keyID;
        String value="京东订单";
        redisTemplate.opsForValue().set(key,value);
        log.info("****key:{}",key);
        log.info("****value:{}",value);
    }
    public  String getOrderKey(Integer key){
        return (String) redisTemplate.opsForValue().get(ORDER_KEY+key);
    }
}
