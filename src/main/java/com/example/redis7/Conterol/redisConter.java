package com.example.redis7.Conterol;

import com.example.redis7.server.OrederService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;

@RestController
@Slf4j
public class redisConter {
   private OrederService orederService;

   @RequestMapping(value = "/add",method = RequestMethod.GET)
   public void addOred(){
        orederService.addOrder();
   }
   public void sd(){
       System.out.println("提交3");

   }

    @RequestMapping(value = "/get/{keyId}",method = RequestMethod.GET)
    public void getOred(@PathVariable Integer keyId){
        orederService.getOrderKey(keyId);
    }

}
