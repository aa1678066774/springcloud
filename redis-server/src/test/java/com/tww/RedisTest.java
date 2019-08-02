package com.tww;

import com.tww.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-05 14:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={RedisServerApplication.class,RedisTest.class})
public class RedisTest {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testSet(){
//        User user=new User("王五",new Date());
//        redisTemplate.opsForValue().set("d",user);
//        ValueOperations<String,User> operations=redisTemplate.opsForValue();
//        System.out.println(operations.get("d"));
//        System.out.println(redisTemplate.opsForValue().get("b"));

        redisTemplate.opsForValue().set("a","123");


        redisTemplate.opsForList().leftPush("b","qqq");
        redisTemplate.opsForList().leftPush("b","www");
        redisTemplate.opsForList().leftPush("b","eee");

        Map<String,Integer> map=new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        redisTemplate.opsForHash().putAll("c",map);


    }


    @Test
    public void testGet(){
        template.opsForValue().set("b","张三");
        System.out.println(template.opsForValue().get("b"));
    }
}
