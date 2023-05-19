package com.example.redis7.demo;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;
//整合 Jedis
public class jedisDemo {
    public static void main(String[] args) {
        //1 connection获得 指定ip和端口号
        Jedis jedis=  new Jedis("192.168.1.4",6381);
        //2 指定服务器访问的密码
        jedis.auth("111111");
        //3 获得了jedis客户端，可以像jdbc一样访问我们的redis
        System.out.println(jedis.ping());
     Set<String> keys=   jedis.keys("*");
        System.out.println(keys);
        jedis.set("k3","hello-jedis");
        System.out.println(jedis.get("k3"));
        jedis.lpush("list","11","12","13");
       List<String>list= jedis.lrange("list",0,-1);
       list.forEach(System.out::println);
    }
}
