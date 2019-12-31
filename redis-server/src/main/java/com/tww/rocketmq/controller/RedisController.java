package com.tww.rocketmq.controller;

import com.tww.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: root
 * @description: redistest
 * @author: weiweiTang
 * @create: 2019-07-05 10:10
 */
@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate template;


    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/test")
    public String testRedis(String name){
//        User user=new User("张三",new Date());
//        template.opsForValue().set("a",name);
//        System.out.println("a:"+template.opsForValue().get("a"));

        User user=new User("王五",new Date());
//        redisTemplate.opsForValue().set("b",name);
        redisTemplate.opsForValue().set("b",user);


        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        User user1=valueOperations.get("b");
        System.out.println("b:"+user1.toString());


        redisTemplate.opsForValue().set("a","天猫精灵");
        ValueOperations<String, String> valueOperations1 = redisTemplate.opsForValue();
        System.out.println("a:"+valueOperations1.get("a"));
        return "redis test:"+name;
    }

}
