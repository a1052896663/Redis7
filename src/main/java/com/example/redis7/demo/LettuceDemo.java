package com.example.redis7.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;

import java.util.List;
/// 整合 Lettuce  出现问题
public class LettuceDemo {
    public static void main(String[] args) {
        //1、使用构建器链式编程来builder我们的redisURI
        RedisURI uri=RedisURI.builder().withSentinel("192.168.1.4",6381,"111111").build();
        //2、创建连接客户端
        RedisClient redisClient=RedisClient.create(uri);
        StatefulRedisConnection<String,String> conn=redisClient.connect();

        //3 通过conn创建操作的command
        RedisCommands commands=conn.sync();

        //*****************************
       List<String>list= commands.keys("*");
       list.forEach(System.out::println);


        //**************************





        // 4 各种关闭释放资源
        conn.close();
        redisClient.shutdown();
    }
}
